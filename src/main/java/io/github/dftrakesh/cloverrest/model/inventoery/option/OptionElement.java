package io.github.dftrakesh.cloverrest.model.inventoery.option;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.dftrakesh.cloverrest.model.inventoery.attribute.Attribute;
import io.github.dftrakesh.cloverrest.model.inventoery.item.Items;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OptionElement {

    private String id;
    private String name;
    private Attribute attribute;
    private Items items;
}