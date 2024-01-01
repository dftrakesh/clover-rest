package io.github.dftrakesh.cloverrest;

import io.github.dftrakesh.cloverrest.handler.JsonBodyHandler;
import io.github.dftrakesh.cloverrest.model.Order.OrderElement;
import io.github.dftrakesh.cloverrest.model.Order.OrderResponse;
import lombok.SneakyThrows;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

import static io.github.dftrakesh.cloverrest.constantcode.ConstantCodes.V3_MERCHANTS;
import static io.github.dftrakesh.cloverrest.constantcode.ConstantCodes.V3_ORDER_END_POINT;

public class CloverRestOrder extends CloverRestSDK {

    public CloverRestOrder(AccessCredentials accessCredentials) {
        super(accessCredentials);
    }

    @SneakyThrows
    public OrderResponse getOrders(HashMap<String, String> params) {
        String sUri = sellingRegionEndpoint + V3_MERCHANTS + accessCredentials.getMerchantId() + V3_ORDER_END_POINT;
        URI uri = addParameters(new URI(sUri), params);

        HttpRequest request = get(uri);
        HttpResponse.BodyHandler<OrderResponse> handler = new JsonBodyHandler<>(OrderResponse.class);
        return getRequestWrapped(request, handler);
    }

    @SneakyThrows
    public OrderElement getOrder(HashMap<String, String> params, String orderId) {
        String s_uri = sellingRegionEndpoint + V3_MERCHANTS + accessCredentials.getMerchantId() + V3_ORDER_END_POINT + "/" + orderId;
        URI uri = addParameters(new URI(s_uri), params);

        HttpRequest request = get(uri);
        HttpResponse.BodyHandler<OrderElement> handler = new JsonBodyHandler<>(OrderElement.class);
        return getRequestWrapped(request, handler);
    }
}