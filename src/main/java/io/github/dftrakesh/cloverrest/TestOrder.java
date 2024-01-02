package io.github.dftrakesh.cloverrest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.github.dftrakesh.cloverrest.model.order.Order;
import io.github.dftrakesh.cloverrest.model.order.Orders;

import java.util.HashMap;

public class TestOrder {
    public static void main(String[] args) throws JsonProcessingException {
        String merchantId="02YV6TXE2XH41";
        String accessToken="11b665ad-17dd-1c2c-d066-7fc86d41721e";
        //String region="US";
        String orderId = "DX9AA5XJ68V9J";

        AccessCredentials accessCredentials= new AccessCredentials();
        accessCredentials.setMerchantId(merchantId);
        accessCredentials.setAccessToken(accessToken);
        //accessCredentials.setRegion(region);

        HashMap<String,String> params = new HashMap<>();
        params.put("expand","lineItems");

        CloverRestOrder order = new CloverRestOrder(accessCredentials);
        Orders orders = order.getOrders(params);
        System.out.println(getJson(orders));

        CloverRestOrder order1 = new CloverRestOrder(accessCredentials);
        Order orderElement = order1.getOrder(params, orderId);
        //System.out.println(getJson(orderElement));
    }

    private static String getJson(Object reports) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(reports);
        return json;
    }
}