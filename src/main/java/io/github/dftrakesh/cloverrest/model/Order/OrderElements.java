package io.github.dftrakesh.cloverrest.model.Order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderElements {
    private List<OrderElement> elements;
}