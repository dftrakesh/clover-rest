package io.github.dftrakesh.cloverrest;

import io.github.dftrakesh.cloverrest.handler.JsonBodyHandler;
import io.github.dftrakesh.cloverrest.model.order.Order;
import io.github.dftrakesh.cloverrest.model.order.Orders;
import lombok.SneakyThrows;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import static io.github.dftrakesh.cloverrest.constantcode.ConstantCodes.V3_MERCHANTS;
import static io.github.dftrakesh.cloverrest.constantcode.ConstantCodes.V3_ORDER_END_POINT;

public class CloverRestOrder extends CloverRestSDK {

    public CloverRestOrder(AccessCredentials accessCredentials) { super(accessCredentials);}

    @SneakyThrows
    public Orders getOrders(HashMap<String, String> params) {
        String sUri = sellingRegionEndpoint + V3_MERCHANTS + accessCredentials.getMerchantId() + V3_ORDER_END_POINT;
        URI uri = addParameters(new URI(sUri), params);

        HttpRequest request = get(uri);
        HttpResponse.BodyHandler<Orders> handler = new JsonBodyHandler<>(Orders.class);
        return getRequestWrapped(request, handler);
    }

    @SneakyThrows
    public Order getOrder(HashMap<String, String> params, String orderId) {
        String sUri = sellingRegionEndpoint + V3_MERCHANTS + accessCredentials.getMerchantId() + V3_ORDER_END_POINT + "/" + orderId;
        URI uri = addParameters(new URI(sUri), params);

        HttpRequest request = get(uri);
        HttpResponse.BodyHandler<Order> handler = new JsonBodyHandler<>(Order.class);
        return getRequestWrapped(request, handler);
    }
}