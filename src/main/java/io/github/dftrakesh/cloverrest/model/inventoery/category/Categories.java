package io.github.dftrakesh.cloverrest.model.inventoery.category;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Categories {

    private List<CategoryElement> elements;
}