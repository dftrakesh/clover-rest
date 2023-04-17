package io.github.dftrakesh.cloverrest;

import io.github.dftrakesh.cloverrest.handler.JsonBodyHandler;
import io.github.dftrakesh.cloverrest.model.merchant.MerchantResponse;
import lombok.SneakyThrows;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class CloverRestMerchant extends CloverRestSDK {

    public CloverRestMerchant(AccessCredentials accessCredentials) {
        super(accessCredentials);
    }

    @SneakyThrows
    public MerchantResponse getMerchant(HashMap<String, String> param) {
        URI uri = addParameters(new URI(sellingRegionEndpoint + "v3/merchants/" + accessCredentials.getMerchantId()), param);

        HttpRequest request = get(uri);
        HttpResponse.BodyHandler<MerchantResponse> handler = new JsonBodyHandler<>(MerchantResponse.class);

        return getRequestWrapped(request, handler);
    }
}