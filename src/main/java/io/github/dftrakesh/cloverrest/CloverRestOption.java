package io.github.dftrakesh.cloverrest;

import io.github.dftrakesh.cloverrest.handler.JsonBodyHandler;
import io.github.dftrakesh.cloverrest.model.inventoery.option.OptionResponse;
import lombok.SneakyThrows;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import static io.github.dftrakesh.cloverrest.constantcode.ConstantCodes.V3_ITEMS_ATTRIBUTE_END_POINT;
import static io.github.dftrakesh.cloverrest.constantcode.ConstantCodes.V3_ITEMS_OPTION_END_POINT;

public class CloverRestOption extends CloverRestSDK {

    public CloverRestOption(AccessCredentials accessCredentials) {
        super(accessCredentials);
    }

    @SneakyThrows
    public OptionResponse getOption(HashMap<String, String> param, String attributeId) {
        String sUri = sellingRegionEndpoint + "v3/merchants/" + accessCredentials.getMerchantId() +
                      V3_ITEMS_ATTRIBUTE_END_POINT + "/" + attributeId + "/" + V3_ITEMS_OPTION_END_POINT;
        URI uri = addParameters(new URI(sUri), param);

        HttpRequest request = get(uri);
        HttpResponse.BodyHandler<OptionResponse> handler = new JsonBodyHandler<>(OptionResponse.class);
        return getRequestWrapped(request, handler);
    }

    @SneakyThrows
    public OptionResponse getAllOption(HashMap<String, String> param) {
        URI uri = addParameters(new URI(sellingRegionEndpoint + "v3/merchants/" + accessCredentials.getMerchantId() + V3_ITEMS_OPTION_END_POINT), param);

        HttpRequest request = get(uri);
        HttpResponse.BodyHandler<OptionResponse> handler = new JsonBodyHandler<>(OptionResponse.class);
        return getRequestWrapped(request, handler);
    }
}