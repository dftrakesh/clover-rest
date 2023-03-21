package io.github.dftrakesh.cloverrest.model.inventoery.attribute;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AttributeResponse {

    private List<AttributeElement> elements;
    private String href;
    private String details;
    private String message;
}