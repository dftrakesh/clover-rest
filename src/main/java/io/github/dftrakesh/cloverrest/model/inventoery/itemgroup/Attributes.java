package io.github.dftrakesh.cloverrest.model.inventoery.itemgroup;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.dftrakesh.cloverrest.model.inventoery.attribute.AttributeElement;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Attributes {

    private List<AttributeElement> elements;
}