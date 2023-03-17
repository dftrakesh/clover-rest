package io.github.dftrakesh.cloverrest;

import io.github.dftrakesh.cloverrest.handler.JsonBodyHandler;
import io.github.dftrakesh.cloverrest.model.token.AccessToken;
import lombok.SneakyThrows;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import static io.github.dftrakesh.cloverrest.constantcode.ConstantCodes.ACCESS_TOKEN_END_POINT;

public class CloverRestToken extends CloverRestSDK {

    public CloverRestToken(AccessCredentials accessCredentials) {
        super(accessCredentials);
    }

    @SneakyThrows
    public AccessToken getAccessToken(HashMap<String, String> param) {
        URI uri = addParameters(new URI(sellingRegionEndpoint + ACCESS_TOKEN_END_POINT), param);

        HttpRequest request = get(uri);
        HttpResponse.BodyHandler<AccessToken> handler = new JsonBodyHandler<>(AccessToken.class);
        return getRequestWrapped(request, handler);
    }
}