package io.github.dftrakesh.cloverrest.model.billing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriptionCountries {

    private List<Element> elements;
}