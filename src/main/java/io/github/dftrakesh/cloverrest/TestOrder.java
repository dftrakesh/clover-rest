package io.github.dftrakesh.cloverrest;

import io.github.dftrakesh.cloverrest.model.Order.OrderElement;
import io.github.dftrakesh.cloverrest.model.Order.OrderResponse;


import java.util.HashMap;

public class TestOrder {
    public static void main(String[] args) {
        String merchantId="02YV6TXE2XH41";
        String accessToken="11b665ad-17dd-1c2c-d066-7fc86d41721e";
        String region="US";
        String orderId = "6RRNPGRQBZZJM";

        AccessCredentials accessCredentials= new AccessCredentials();
        accessCredentials.setMerchantId(merchantId);
        accessCredentials.setAccessToken(accessToken);
        accessCredentials.setRegion(region);

        HashMap<String,String> params = new HashMap<>();
        params.put("expand","lineItems");

        CloverRestOrder order = new CloverRestOrder(accessCredentials);
        OrderResponse orderResponse = order.getAllOrdersWithLineItems(params);
        System.out.println(orderResponse);

        CloverRestOrder order1 = new CloverRestOrder(accessCredentials);
        OrderElement orderElement = order1.getOrderWithLineItems(params, orderId);
        System.out.println(orderElement);
    }
}
