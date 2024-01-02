package io.github.dftrakesh.cloverrest.model.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LineItem {

    private String id;
    private OrderRef orderRef;
    private Item item;
    private String name;
    private String alternateName;
    private Double price;
    private Integer unitQty;
    private String unitName;
    private Boolean printed;
    private Long createdTime;
    private Long orderClientCreatedTime;
    private Boolean exchanged;
    private Boolean refunded;
    private Boolean isRevenue;
}