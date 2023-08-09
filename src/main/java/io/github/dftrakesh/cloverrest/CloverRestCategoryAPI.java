package io.github.dftrakesh.cloverrest;

import io.github.dftrakesh.cloverrest.handler.JsonBodyHandler;
import io.github.dftrakesh.cloverrest.model.inventoery.category.CategoriesResponse;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

import static io.github.dftrakesh.cloverrest.constantcode.ConstantCodes.V3_ITEMS_CATEGORY_END_POINT;

public class CloverRestCategoryAPI extends CloverRestSDK {

    public CloverRestCategoryAPI(AccessCredentials accessCredentials) {
        super(accessCredentials);
    }

    public CategoriesResponse getAllCategories(HashMap<String, String> param) {
        URI uri = addParameters(URI.create(sellingRegionEndpoint + "v3/merchants/" + accessCredentials.getMerchantId() + V3_ITEMS_CATEGORY_END_POINT), param);

        HttpRequest request = get(uri);
        HttpResponse.BodyHandler<CategoriesResponse> handler = new JsonBodyHandler<>(CategoriesResponse.class);
        return getRequestWrapped(request, handler);
    }
}