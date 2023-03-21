package io.github.dftrakesh.cloverrest;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.dftrakesh.cloverrest.handler.JsonBodyHandler;
import io.github.dftrakesh.cloverrest.model.inventoery.attribute.AttributeElement;
import io.github.dftrakesh.cloverrest.model.inventoery.attribute.AttributeElementRequest;
import io.github.dftrakesh.cloverrest.model.inventoery.attribute.AttributeResponse;
import lombok.SneakyThrows;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import static io.github.dftrakesh.cloverrest.constantcode.ConstantCodes.V3_ITEMS_ATTRIBUTE_END_POINT;

public class CloverRestAttribute extends CloverRestSDK {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public CloverRestAttribute(AccessCredentials accessCredentials) {
        super(accessCredentials);
    }

    @SneakyThrows
    public AttributeElement getAttribute(HashMap<String, String> param, String attributeId) {
        URI uri = addParameters(new URI(sellingRegionEndpoint + "v3/merchants/" + accessCredentials.getMerchantId() + V3_ITEMS_ATTRIBUTE_END_POINT + "/" + attributeId), param);

        HttpRequest request = get(uri);
        HttpResponse.BodyHandler<AttributeElement> handler = new JsonBodyHandler<>(AttributeElement.class);
        return getRequestWrapped(request, handler);
    }

    @SneakyThrows
    public AttributeResponse getAllAttribute(HashMap<String, String> param) {
        URI uri = addParameters(new URI(sellingRegionEndpoint + "v3/merchants/" + accessCredentials.getMerchantId() + V3_ITEMS_ATTRIBUTE_END_POINT), param);

        HttpRequest request = get(uri);
        HttpResponse.BodyHandler<AttributeResponse> handler = new JsonBodyHandler<>(AttributeResponse.class);
        return getRequestWrapped(request, handler);
    }

    @SneakyThrows
    public AttributeElement createAttribute(AttributeElementRequest attributeElementRequest) {
        URI uri = new URI(sellingRegionEndpoint + "v3/merchants/" + accessCredentials.getMerchantId() + V3_ITEMS_ATTRIBUTE_END_POINT);

        String jsonBody = objectMapper.writeValueAsString(attributeElementRequest);

        HttpRequest request = post(uri, jsonBody);
        HttpResponse.BodyHandler<AttributeElement> handler = new JsonBodyHandler<>(AttributeElement.class);
        return getRequestWrapped(request, handler);
    }

    @SneakyThrows
    public AttributeElement updateAttribute(AttributeElementRequest attributeElementRequest, String attributeId) {
        URI uri = new URI(sellingRegionEndpoint + "v3/merchants/" + accessCredentials.getMerchantId() + V3_ITEMS_ATTRIBUTE_END_POINT + "/" + attributeId);

        String jsonBody = objectMapper.writeValueAsString(attributeElementRequest);

        HttpRequest request = post(uri, jsonBody);
        HttpResponse.BodyHandler<AttributeElement> handler = new JsonBodyHandler<>(AttributeElement.class);
        return getRequestWrapped(request, handler);
    }

    @SneakyThrows
    public void deleteAttribute(String attributeId) {
        URI uri = new URI(sellingRegionEndpoint + "v3/merchants/" + accessCredentials.getMerchantId() + V3_ITEMS_ATTRIBUTE_END_POINT + "/" + attributeId);

        HttpRequest request = delete(uri);
        getRequestWrapped(request, HttpResponse.BodyHandlers.ofString());
    }
}