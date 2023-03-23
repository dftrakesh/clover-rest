package io.github.dftrakesh.cloverrest.model.inventoery.taxrate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaxRateElement {

    private String id;
    private String name;
    private String taxType;
    private Integer rate;
    private Boolean isDefault;
}
