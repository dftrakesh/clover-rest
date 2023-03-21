package io.github.dftrakesh.cloverrest.model.inventoery.tag;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TagElement {

    private String id;
    private String name;
    private Boolean showInReporting;
}