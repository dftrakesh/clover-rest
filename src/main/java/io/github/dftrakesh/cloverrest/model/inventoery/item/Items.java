package io.github.dftrakesh.cloverrest.model.inventoery.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Items {

    private List<Item> elements;
}