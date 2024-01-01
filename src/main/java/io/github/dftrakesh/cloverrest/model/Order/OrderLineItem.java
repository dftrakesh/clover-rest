package io.github.dftrakesh.cloverrest.model.Order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderLineItem {

    private String id;
    private String name;
    private Double price;
    private Integer unitQty;
    private String unitName;
    private Boolean printed;
    private Long orderClientCreatedTime;
    private Long createdTime;
    private Boolean exchanged;
    private Boolean refunded;
    private Boolean isRevenue;
}
