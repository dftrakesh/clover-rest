package io.github.dftrakesh.cloverrest.model.inventoery.itemgroup;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemGroupResponse {

    private List<ItemGroupElement> elements;
    private String href;
    private String details;
    private String message;
}