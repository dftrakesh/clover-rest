package io.github.dftrakesh.cloverrest.model.merchant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantResponse {

    private String href;
    private String id;
    private String name;
    private Owner owner;
    private Address address;
    private MerchantPlan merchantPlan;
    private Long createdTime;
    private Orders orders;
    private Payments payments;
    private TaxRates taxRates;
    private BillingInfo billingInfo;
    private Boolean isBillable;
}