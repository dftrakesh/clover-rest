package io.github.dftrakesh.cloverrest.model.inventoery.option;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.dftrakesh.cloverrest.model.inventoery.attribute.Attribute;
import io.github.dftrakesh.cloverrest.model.inventoery.item.Item;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OptionElement {

    private String id;
    private String name;
    private Attribute attribute;
    private List<Item> items;
}