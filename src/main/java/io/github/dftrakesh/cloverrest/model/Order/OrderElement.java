package io.github.dftrakesh.cloverrest.model.Order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderElement {

    private String id;
    private String href;
    private String currency;
    private String paymentState;
    private Boolean taxRemoved;
    private Boolean isVat;
    private String state;
    private Double createdTime;
    private Double modifiedTime;
    private ListOrderLineItems lineItems;
}