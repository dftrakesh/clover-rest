package io.github.dftrakesh.cloverrest.model.updateInventory;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class updateRequest {
    /*private String id;*/
    private Integer quantity;
}