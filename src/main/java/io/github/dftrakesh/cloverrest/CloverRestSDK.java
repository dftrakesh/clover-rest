package io.github.dftrakesh.cloverrest;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.dftrakesh.cloverrest.constantcode.ConstantCodes;
import lombok.SneakyThrows;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import static io.github.dftrakesh.cloverrest.constantcode.ConstantCodes.AUTHORIZATION;
import static io.github.dftrakesh.cloverrest.constantcode.ConstantCodes.AUTHORIZE_END_POINT;
import static io.github.dftrakesh.cloverrest.constantcode.ConstantCodes.HTTP_HEADER_CONTENT_TYPE;
import static io.github.dftrakesh.cloverrest.constantcode.ConstantCodes.HTTP_HEADER_VALUE_APPLICATION_JSON;
import static io.github.dftrakesh.cloverrest.constantcode.ConstantCodes.MAX_ATTEMPTS;
import static io.github.dftrakesh.cloverrest.constantcode.ConstantCodes.TIME_OUT_DURATION;

public class CloverRestSDK {

    protected HttpClient client;
    protected AccessCredentials accessCredentials;
    protected String sellingRegionEndpoint;
    protected final ObjectMapper objectMapper;

    public CloverRestSDK(AccessCredentials accessCredentials) {
        client = HttpClient.newHttpClient();
        this.accessCredentials = accessCredentials;
        this.objectMapper = new ObjectMapper();

        if (ConstantCodes.CLOVER_REST_REGION_US_AND_CANADA.equalsIgnoreCase(accessCredentials.getRegion())) {
            this.sellingRegionEndpoint = "https://www.clover.com/";
        } else if (ConstantCodes.CLOVER_REST_REGION_EU.equalsIgnoreCase(accessCredentials.getRegion())) {
            this.sellingRegionEndpoint = "https://eu.clover.com/";
        } else if (ConstantCodes.CLOVER_REST_REGION_LATAM.equalsIgnoreCase(accessCredentials.getRegion())) {
            this.sellingRegionEndpoint = "https://api.la.clover.com/";
        } else {
            this.sellingRegionEndpoint = null;
        }
    }

    public String getRedirectURL(String clientId) {
        return sellingRegionEndpoint + AUTHORIZE_END_POINT + clientId;
    }

    @SneakyThrows
    protected HttpRequest get(URI uri) {
        return HttpRequest.newBuilder(uri)
                          .header(AUTHORIZATION, "Bearer " + this.accessCredentials.getAccessToken())
                          .header(HTTP_HEADER_CONTENT_TYPE, HTTP_HEADER_VALUE_APPLICATION_JSON)
                          .GET()
                          .build();
    }

    @SneakyThrows
    protected HttpRequest post(URI uri, final Object object) {
        String jsonBody = objectMapper.writeValueAsString(object);
        return HttpRequest.newBuilder(uri)
            .header(AUTHORIZATION, "Bearer " + this.accessCredentials.getAccessToken())
            .header(HTTP_HEADER_CONTENT_TYPE, HTTP_HEADER_VALUE_APPLICATION_JSON)
            .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
            .build();
    }

    @SneakyThrows
    protected URI addParameters(URI uri, HashMap<String, String> params) {

        String query = uri.getQuery();
        StringBuilder builder = new StringBuilder();
        if (query != null)
            builder.append(query);

        for (Map.Entry<String, String> entry : params.entrySet()) {
            String keyValueParam = entry.getKey() + "=" + entry.getValue();
            if (!builder.toString().isEmpty())
                builder.append("&");
            builder.append(keyValueParam);
        }
        return new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), builder.toString(), uri.getFragment());
    }

    @SneakyThrows
    public <T> T getRequestWrapped(HttpRequest request, HttpResponse.BodyHandler<T> handler) {

        return client.sendAsync(request, handler)
                     .thenComposeAsync(response -> tryResend(client, request, handler, response, 1))
                     .get()
                     .body();
    }

    @SneakyThrows
    public <T> CompletableFuture<HttpResponse<T>> tryResend(HttpClient client,
                                                            HttpRequest request,
                                                            HttpResponse.BodyHandler<T> handler,
                                                            HttpResponse<T> resp, int count) {
        if (resp.statusCode() == 409 && count < MAX_ATTEMPTS) {
            Thread.sleep(TIME_OUT_DURATION);
            return client.sendAsync(request, handler)
                         .thenComposeAsync(response -> tryResend(client, request, handler, response, count + 1));
        }
        return CompletableFuture.completedFuture(resp);
    }
}