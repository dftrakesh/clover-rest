package io.github.dftrakesh.cloverrest.model.inventoery.modifier;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.dftrakesh.cloverrest.model.inventoery.item.Items;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModifierGroupElement {

    private String id;
    private String name;
    private Boolean showByDefault;
    private Items items;
    private Integer sortOrder;
}