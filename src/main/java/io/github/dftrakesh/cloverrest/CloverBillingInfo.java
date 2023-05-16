package io.github.dftrakesh.cloverrest;

import io.github.dftrakesh.cloverrest.handler.JsonBodyHandler;
import io.github.dftrakesh.cloverrest.model.billing.BillingInfoResponse;
import lombok.SneakyThrows;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CloverBillingInfo extends CloverRestSDK {

    public CloverBillingInfo(AccessCredentials accessCredentials) {
        super(accessCredentials);
    }

    @SneakyThrows
    public BillingInfoResponse getBillingInfo(String appId) {
        URI uri = new URI(sellingRegionEndpoint + "/v3/apps/" + appId + "/merchants/" + accessCredentials.getMerchantId() + "/billing_info");

        HttpRequest request = get(uri);
        HttpResponse.BodyHandler<BillingInfoResponse> handler = new JsonBodyHandler<>(BillingInfoResponse.class);
        return getRequestWrapped(request, handler);
    }
}