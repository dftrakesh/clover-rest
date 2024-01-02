package io.github.dftrakesh.cloverrest.model.inventoery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.dftrakesh.cloverrest.model.order.Item;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryResponse {

    private Item item;
    private Integer stockCount;
    private Double quantity;
}