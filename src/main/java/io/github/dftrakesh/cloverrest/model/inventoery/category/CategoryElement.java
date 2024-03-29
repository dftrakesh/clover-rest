package io.github.dftrakesh.cloverrest.model.inventoery.category;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.dftrakesh.cloverrest.model.inventoery.item.Items;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryElement {

    private String id;
    private String name;
    private Integer sortOrder;
    private Items items;
}