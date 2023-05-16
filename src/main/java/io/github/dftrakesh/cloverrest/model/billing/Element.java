package io.github.dftrakesh.cloverrest.model.billing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Element {

    private String id;
    private String name;
    private Double amount;
    private String country;
    private String description;
    private Boolean active;
    private AppSubscription appSubscription;
}