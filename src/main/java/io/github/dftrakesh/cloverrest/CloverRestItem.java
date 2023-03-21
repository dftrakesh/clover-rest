package io.github.dftrakesh.cloverrest;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.dftrakesh.cloverrest.handler.JsonBodyHandler;
import io.github.dftrakesh.cloverrest.model.inventoery.item.ItemResponse;
import lombok.SneakyThrows;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import static io.github.dftrakesh.cloverrest.constantcode.ConstantCodes.V3_ITEMS_END_POINT;

public class CloverRestItem extends CloverRestSDK {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public CloverRestItem(AccessCredentials accessCredentials) {
        super(accessCredentials);
    }

    @SneakyThrows
    public ItemResponse getItems(HashMap<String, String> param) {
        URI uri = addParameters(new URI(sellingRegionEndpoint + "v3/merchants/" + accessCredentials.getMerchantId() + V3_ITEMS_END_POINT), param);

        HttpRequest request = get(uri);
        HttpResponse.BodyHandler<ItemResponse> handler = new JsonBodyHandler<>(ItemResponse.class);
        return getRequestWrapped(request, handler);
    }

    @SneakyThrows
    public ItemResponse getAllItems(HashMap<String, String> param, String itemId) {
        URI uri = addParameters(new URI(sellingRegionEndpoint + "v3/merchants/" + accessCredentials.getMerchantId() + V3_ITEMS_END_POINT + "/" + itemId), param);

        HttpRequest request = get(uri);
        HttpResponse.BodyHandler<ItemResponse> handler = new JsonBodyHandler<>(ItemResponse.class);
        return getRequestWrapped(request, handler);
    }
}