package io.github.dftrakesh.cloverrest.model.inventoery.attribute;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.dftrakesh.cloverrest.model.inventoery.itemgroup.ItemGroup;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AttributeElement {

    private String id;
    private String name;
    private ItemGroup itemGroup;
}