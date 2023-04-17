package io.github.dftrakesh.cloverrest.model.merchant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

    private String href;
    private String address1;
    private String city;
    private String country;
    private String state;
    private String zip;
}