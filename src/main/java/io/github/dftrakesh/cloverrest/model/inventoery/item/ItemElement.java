package io.github.dftrakesh.cloverrest.model.inventoery.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemElement {

    private String id;
    private Boolean hidden;
    private Boolean available;
    private Boolean autoManage;
    private String name;
    private String code;
    private String sku;
    private Double price;
    private String priceType;
    private Boolean defaultTaxRates;
    private Double cost;
    private Boolean isRevenue;
    private Long modifiedTime;
    private String colorCode;
}