package io.github.dftrakesh.cloverrest.model.inventoery.itemgroup;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.dftrakesh.cloverrest.model.inventoery.attribute.Attributes;
import io.github.dftrakesh.cloverrest.model.inventoery.item.ItemResponse;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemGroupElement {

    private String id;
    private String name;
    private ItemResponse items;
    private Attributes attributes;
}