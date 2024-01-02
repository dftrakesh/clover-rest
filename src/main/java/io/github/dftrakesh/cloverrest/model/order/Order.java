package io.github.dftrakesh.cloverrest.model.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {

    private String href;
    private String id;
    private String currency;
    private Employee employee;
    private Integer total;
    private String paymentState;
    private Boolean taxRemoved;
    private Boolean isVat;
    private String state;
    private Boolean manualTransaction;
    private Boolean groupLineItems;
    private Boolean testMode;
    private Long createdTime;
    private Long clientCreatedTime;
    private Long modifiedTime;
    private LineItems lineItems;
}