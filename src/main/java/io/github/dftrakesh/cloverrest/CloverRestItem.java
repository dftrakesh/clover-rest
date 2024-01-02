package io.github.dftrakesh.cloverrest;

import io.github.dftrakesh.cloverrest.handler.JsonBodyHandler;
import io.github.dftrakesh.cloverrest.model.inventoery.item.ItemElement;
import io.github.dftrakesh.cloverrest.model.inventoery.item.ItemResponse;
import io.github.dftrakesh.cloverrest.model.updateInventory.InventoryRequest;
import io.github.dftrakesh.cloverrest.model.updateInventory.InventoryResponse;
import lombok.SneakyThrows;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import static io.github.dftrakesh.cloverrest.constantcode.ConstantCodes.V3_ITEMS_END_POINT;
import static io.github.dftrakesh.cloverrest.constantcode.ConstantCodes.V3_ITEM_STOCKS_ENDPOINT;
import static io.github.dftrakesh.cloverrest.constantcode.ConstantCodes.V3_MERCHANTS;

public class CloverRestItem extends CloverRestSDK {

    public CloverRestItem(AccessCredentials accessCredentials) {
        super(accessCredentials);
    }

    @SneakyThrows
    public ItemResponse getAllItem(HashMap<String, String> param) {
        URI uri = addParameters(new URI(sellingRegionEndpoint + "v3/merchants/" + accessCredentials.getMerchantId() + V3_ITEMS_END_POINT), param);

        HttpRequest request = get(uri);
        HttpResponse.BodyHandler<ItemResponse> handler = new JsonBodyHandler<>(ItemResponse.class);
        return getRequestWrapped(request, handler);
    }

    @SneakyThrows
    public ItemElement getItem(HashMap<String, String> param, String itemId) {
        URI uri = addParameters(new URI(sellingRegionEndpoint + "v3/merchants/" + accessCredentials.getMerchantId() + V3_ITEMS_END_POINT + "/" + itemId), param);

        HttpRequest request = get(uri);
        HttpResponse.BodyHandler<ItemElement> handler = new JsonBodyHandler<>(ItemElement.class);
        return getRequestWrapped(request, handler);
    }

    @SneakyThrows
    public InventoryResponse updateInventory(InventoryRequest inventoryRequest , String itemId ) {
        String sUri = sellingRegionEndpoint + V3_MERCHANTS + accessCredentials.getMerchantId() + V3_ITEM_STOCKS_ENDPOINT + "/" + itemId;
        URI uri = new URI(sUri);

        HttpRequest request = post(uri,inventoryRequest);
        HttpResponse.BodyHandler<InventoryResponse> handler = new JsonBodyHandler<>(InventoryResponse.class);
        return getRequestWrapped(request,handler);
    }
}