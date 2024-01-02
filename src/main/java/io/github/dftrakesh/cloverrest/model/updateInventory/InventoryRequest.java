package io.github.dftrakesh.cloverrest.model.updateInventory;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InventoryRequest {
    private Integer quantity;
}