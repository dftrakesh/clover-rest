package io.github.dftrakesh.cloverrest;

import io.github.dftrakesh.cloverrest.model.updateInventory.updateRequest;
import io.github.dftrakesh.cloverrest.model.updateInventory.updateStockResponse;

public class Test2 {
    public static void main(String[] args) {
        String merchantId="02YV6TXE2XH41";
        String accessToken="11b665ad-17dd-1c2c-d066-7fc86d41721e";
        String itemId="8A9E98MGRM6RM";

        AccessCredentials accessCredentials = new AccessCredentials();
        accessCredentials.setMerchantId(merchantId);
        accessCredentials.setAccessToken(accessToken);

        updateRequest updateRequest = new updateRequest();
        updateRequest.setQuantity(77);

        CloverRestUpdateInventory cloverRestUpdateInventory = new CloverRestUpdateInventory(accessCredentials);
        updateStockResponse response = cloverRestUpdateInventory.update(updateRequest,itemId);
        System.out.println(response);
    }
}