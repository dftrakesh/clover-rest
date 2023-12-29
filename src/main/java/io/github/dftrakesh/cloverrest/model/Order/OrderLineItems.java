package io.github.dftrakesh.cloverrest.model.Order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderLineItems {

    private String id;
    private String name;
    private Double price;
    private Boolean printed;
    private Double createdTime;
    private Boolean exchanged;
    private Boolean refunded;
    private Boolean isRevenue;
}
