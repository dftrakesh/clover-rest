package io.github.dftrakesh.cloverrest;

import io.github.dftrakesh.cloverrest.handler.JsonBodyHandler;
import io.github.dftrakesh.cloverrest.model.Order.OrderElement;
import io.github.dftrakesh.cloverrest.model.Order.OrderResponse;
import lombok.SneakyThrows;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

import static io.github.dftrakesh.cloverrest.constantcode.ConstantCodes.V3_ORDER_END_POINT;

public class CloverRestOrder extends CloverRestSDK {

    public CloverRestOrder(AccessCredentials accessCredentials) {
        super(accessCredentials);
    }

    @SneakyThrows
    public OrderResponse getAllOrdersWithLineItems(HashMap<String, String> params) {
        URI uri = addParameters(new URI(sellingRegionEndpoint + "v3/merchants/" + accessCredentials.getMerchantId() + V3_ORDER_END_POINT), params);

        HttpRequest request = get(uri);
        HttpResponse.BodyHandler<OrderResponse> handler = new JsonBodyHandler<>(OrderResponse.class);
        return getRequestWrapped(request, handler);
    }

    @SneakyThrows
    public OrderElement getOrderWithLineItems(HashMap<String, String> params, String orderId) {
        URI uri = addParameters(new URI(sellingRegionEndpoint + "v3/merchants/" + accessCredentials.getMerchantId() + V3_ORDER_END_POINT + "/" + orderId), params);

        HttpRequest request = get(uri);
        HttpResponse.BodyHandler<OrderElement> handler = new JsonBodyHandler<>(OrderElement.class);
        return getRequestWrapped(request, handler);
    }
}