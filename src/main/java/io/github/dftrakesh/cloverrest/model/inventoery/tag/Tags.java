package io.github.dftrakesh.cloverrest.model.inventoery.tag;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tags {

    private List<TagElement> elements;
}