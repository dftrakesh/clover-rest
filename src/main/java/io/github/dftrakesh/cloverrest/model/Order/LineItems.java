package io.github.dftrakesh.cloverrest.model.Order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LineItems {

    @JsonProperty("elements")
    private List<LineItem> lineItemList;
}