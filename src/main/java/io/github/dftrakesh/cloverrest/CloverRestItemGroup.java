package io.github.dftrakesh.cloverrest;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.dftrakesh.cloverrest.handler.JsonBodyHandler;
import io.github.dftrakesh.cloverrest.model.inventoery.itemgroup.ItemGroupElement;
import io.github.dftrakesh.cloverrest.model.inventoery.itemgroup.ItemGroupResponse;
import lombok.SneakyThrows;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import static io.github.dftrakesh.cloverrest.constantcode.ConstantCodes.V3_ITEMS_GROUP_END_POINT;

public class CloverRestItemGroup extends CloverRestSDK {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public CloverRestItemGroup(AccessCredentials accessCredentials) {
        super(accessCredentials);
    }

    @SneakyThrows
    public ItemGroupElement getItemGroup(HashMap<String, String> param, String id) {
        URI uri = addParameters(new URI(sellingRegionEndpoint + "v3/merchants/" + accessCredentials.getMerchantId() + V3_ITEMS_GROUP_END_POINT + "/" + id), param);

        HttpRequest request = get(uri);
        HttpResponse.BodyHandler<ItemGroupElement> handler = new JsonBodyHandler<>(ItemGroupElement.class);
        return getRequestWrapped(request, handler);
    }

    @SneakyThrows
    public ItemGroupResponse getAllItemGroup(HashMap<String, String> param) {
        URI uri = addParameters(new URI(sellingRegionEndpoint + "v3/merchants/" + accessCredentials.getMerchantId() + V3_ITEMS_GROUP_END_POINT), param);

        HttpRequest request = get(uri);
        HttpResponse.BodyHandler<ItemGroupResponse> handler = new JsonBodyHandler<>(ItemGroupResponse.class);
        return getRequestWrapped(request, handler);
    }
}