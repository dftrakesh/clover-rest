package io.github.dftrakesh.cloverrest.model.updateInventory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class updateStockResponse {
    @JsonProperty("item")
    private Item item;
    private Integer stockCount;
    private Double quantity;
}