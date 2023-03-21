package io.github.dftrakesh.cloverrest.model.inventoery.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemStock {

    private Item item;
    private Integer stockCount;
    private Double quantity;
    private Long modifiedTime;
}
