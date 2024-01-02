package io.github.dftrakesh.cloverrest.model.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Orders {

    @JsonProperty("elements")
    private List<Order> orderList;
}