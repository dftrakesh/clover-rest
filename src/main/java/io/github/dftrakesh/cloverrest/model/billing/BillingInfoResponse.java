package io.github.dftrakesh.cloverrest.model.billing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingInfoResponse {

    private AppSubscription appSubscription;
    private Boolean isInTrial;
    private Long billingStartTime;
    private String status;
    private Integer daysLapsed;
}