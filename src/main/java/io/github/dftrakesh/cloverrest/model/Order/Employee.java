package io.github.dftrakesh.cloverrest.model.Order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {
    private String id;
}