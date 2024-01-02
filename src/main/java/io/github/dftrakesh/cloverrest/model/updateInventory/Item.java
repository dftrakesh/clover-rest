package io.github.dftrakesh.cloverrest.model.updateInventory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
    private String id;
}