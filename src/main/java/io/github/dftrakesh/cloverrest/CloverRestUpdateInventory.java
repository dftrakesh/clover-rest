package io.github.dftrakesh.cloverrest;

import io.github.dftrakesh.cloverrest.handler.JsonBodyHandler;
import io.github.dftrakesh.cloverrest.model.updateInventory.updateRequest;
import io.github.dftrakesh.cloverrest.model.updateInventory.updateStockResponse;
import lombok.SneakyThrows;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import static io.github.dftrakesh.cloverrest.constantcode.ConstantCodes.V3_ITEM_STOCKS_ENDPOINT;
import static io.github.dftrakesh.cloverrest.constantcode.ConstantCodes.V3_MERCHANTS;

public class CloverRestUpdateInventory extends CloverRestSDK {

    public CloverRestUpdateInventory(AccessCredentials accessCredentials) { super(accessCredentials);}

    @SneakyThrows
    public updateStockResponse update(updateRequest inventoryRequest , String itemId ) {
        String sUri ="https://sandbox.dev.clover.com/" + V3_MERCHANTS + accessCredentials.getMerchantId() + V3_ITEM_STOCKS_ENDPOINT + "/" + itemId;
        URI uri = new URI(sUri);
        HttpRequest request = post(uri,inventoryRequest);
        HttpResponse.BodyHandler<updateStockResponse> handler = new JsonBodyHandler<>(updateStockResponse.class);
        return getRequestWrapped(request,handler);
    }
}