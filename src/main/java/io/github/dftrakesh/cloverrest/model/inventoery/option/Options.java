package io.github.dftrakesh.cloverrest.model.inventoery.option;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Options {

    private List<OptionElement> elements;
}