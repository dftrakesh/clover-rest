package io.github.dftrakesh.cloverrest.model.inventoery.category;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoriesResponse {

    private List<CategoryElement> elements;
    private String href;
}