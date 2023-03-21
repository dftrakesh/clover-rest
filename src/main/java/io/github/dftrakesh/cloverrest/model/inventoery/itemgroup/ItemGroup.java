package io.github.dftrakesh.cloverrest.model.inventoery.itemgroup;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemGroup {

    private String id;
}