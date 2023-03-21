package io.github.dftrakesh.cloverrest.model.inventoery.attribute;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.dftrakesh.cloverrest.model.inventoery.itemgroup.ItemGroup;
import io.github.dftrakesh.cloverrest.model.inventoery.option.OptionElement;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AttributeElementRequest {

    private String id;
    private String name;
    private ItemGroup itemGroup;
    private List<OptionElement> options;
}