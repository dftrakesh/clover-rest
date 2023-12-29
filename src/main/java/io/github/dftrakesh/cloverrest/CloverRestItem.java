package io.github.dftrakesh.cloverrest;

import io.github.dftrakesh.cloverrest.handler.JsonBodyHandler;
import io.github.dftrakesh.cloverrest.model.inventoery.item.ItemElement;
import io.github.dftrakesh.cloverrest.model.inventoery.item.ItemResponse;
import lombok.SneakyThrows;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import static io.github.dftrakesh.cloverrest.constantcode.ConstantCodes.V3_ITEMS_END_POINT;

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


}