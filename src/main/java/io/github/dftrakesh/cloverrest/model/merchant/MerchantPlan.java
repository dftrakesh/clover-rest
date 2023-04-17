package io.github.dftrakesh.cloverrest.model.merchant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantPlan {

    private String id;
}