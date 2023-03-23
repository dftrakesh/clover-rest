package io.github.dftrakesh.cloverrest.model.inventoery.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.dftrakesh.cloverrest.model.inventoery.category.Categories;
import io.github.dftrakesh.cloverrest.model.inventoery.itemgroup.ItemGroup;
import io.github.dftrakesh.cloverrest.model.inventoery.modifier.ModifierGroups;
import io.github.dftrakesh.cloverrest.model.inventoery.option.Options;
import io.github.dftrakesh.cloverrest.model.inventoery.tag.Tags;
import io.github.dftrakesh.cloverrest.model.inventoery.taxrate.TaxRates;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemElement {

    private String id;
    private Boolean hidden;
    private Boolean available;
    private Boolean autoManage;
    private ItemGroup itemGroup;
    private Options options;
    private String name;
    private String code;
    private String sku;
    private Double price;
    private String priceType;
    private Boolean defaultTaxRates;
    private Double cost;
    private Boolean isRevenue;
    private TaxRates taxRates;
    private ModifierGroups modifierGroups;
    private Categories categories;
    private Tags tags;
    private ItemStock itemStock;
    private Long modifiedTime;
    private String colorCode;
}