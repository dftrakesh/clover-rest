package io.github.dftrakesh.cloverrest;

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

public class CloverRestSDK {

    protected HttpClient client;
    protected AccessCredentials accessCredentials;
    protected String sellingRegionEndpoint;

    public CloverRestSDK(AccessCredentials accessCredentials) {
        client = HttpClient.newHttpClient();
        this.accessCredentials = accessCredentials;

        if (ConstantCodes.CLOVER_REST_REGION_US_AND_CANADA.equalsIgnoreCase(accessCredentials.getRegion())) {
            this.sellingRegionEndpoint = "https://www.clover.com/";
        } else if (ConstantCodes.CLOVER_REST_REGION_EU.equalsIgnoreCase(accessCredentials.getRegion())) {
            this.sellingRegionEndpoint = "https://eu.clover.com/";
        } else {
            this.sellingRegionEndpoint = null;
        }
    }

    @SneakyThrows
    protected HttpRequest get(URI uri) {
        return HttpRequest.newBuilder(uri)
                          .header(AUTHORIZATION, "Bearer " + this.accessCredentials.getAccessToken())
                          .GET()
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
        if (resp.statusCode() == 409 && count < 50) {
            Thread.sleep(3000);
            return client.sendAsync(request, handler)
                .thenComposeAsync(response -> tryResend(client, request, handler, response, count + 1));
        }
        return CompletableFuture.completedFuture(resp);
    }
}