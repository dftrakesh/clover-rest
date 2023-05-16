package io.github.dftrakesh.cloverrest.model.billing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class App {

    private String id;
}