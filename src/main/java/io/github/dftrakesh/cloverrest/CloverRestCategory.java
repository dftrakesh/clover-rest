package io.github.dftrakesh.cloverrest;

import io.github.dftrakesh.cloverrest.handler.JsonBodyHandler;
import io.github.dftrakesh.cloverrest.model.inventoery.category.CategoryElement;
import io.github.dftrakesh.cloverrest.model.inventoery.category.CategoryResponse;
import lombok.SneakyThrows;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import static io.github.dftrakesh.cloverrest.constantcode.ConstantCodes.V3_ITEMS_CATEGORY_END_POINT;

public class CloverRestCategory extends CloverRestSDK {

    public CloverRestCategory(AccessCredentials accessCredentials) {
        super(accessCredentials);
    }

    @SneakyThrows
    public CategoryElement getCategory(HashMap<String, String> param) {
        URI uri = addParameters(new URI(sellingRegionEndpoint + "v3/merchants/" + accessCredentials.getMerchantId() + V3_ITEMS_CATEGORY_END_POINT), param);

        HttpRequest request = get(uri);
        HttpResponse.BodyHandler<CategoryElement> handler = new JsonBodyHandler<>(CategoryElement.class);
        return getRequestWrapped(request, handler);
    }

    @SneakyThrows
    public CategoryResponse getAllCategory(HashMap<String, String> param, String categoryId) {
        URI uri = addParameters(new URI(sellingRegionEndpoint + "v3/merchants/" + accessCredentials.getMerchantId() + V3_ITEMS_CATEGORY_END_POINT + "/" + categoryId), param);

        HttpRequest request = get(uri);
        HttpResponse.BodyHandler<CategoryResponse> handler = new JsonBodyHandler<>(CategoryResponse.class);
        return getRequestWrapped(request, handler);
    }
}