package io.github.dftrakesh.cloverrest.model.inventoery.attribute;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Attribute {

    private String id;
}