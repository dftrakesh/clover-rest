package io.github.dftrakesh.cloverrest.model.inventoery.taxrate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaxRates {

    private List<TaxRateElement> elements;
}
