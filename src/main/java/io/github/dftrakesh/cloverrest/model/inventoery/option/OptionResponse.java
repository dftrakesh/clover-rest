package io.github.dftrakesh.cloverrest.model.inventoery.option;

import lombok.Data;
import java.util.List;

@Data
public class OptionResponse {

    private List<OptionElement> elements;
    private String href;
    private String details;
    private String message;
}