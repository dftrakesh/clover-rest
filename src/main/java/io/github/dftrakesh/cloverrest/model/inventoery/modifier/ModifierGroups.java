package io.github.dftrakesh.cloverrest.model.inventoery.modifier;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModifierGroups {

    private List<ModifierGroupElement> elements;
}