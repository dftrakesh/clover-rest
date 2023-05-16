package io.github.dftrakesh.cloverrest.model.billing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppSubscription {

    private String id;
    private String name;
    private Double amount;
    private String description;
    private Boolean active;
    private Boolean plan;
    private SubscriptionCountries subscriptionCountries;
    private App app;
    private String label;
}