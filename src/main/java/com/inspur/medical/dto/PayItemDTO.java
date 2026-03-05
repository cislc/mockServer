package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayItemDTO {
    
    @JsonProperty("Item")
    private String item;
    
    @JsonProperty("ItemCode")
    private String itemCode;
    
    @JsonProperty("ItemName")
    private String itemName;
    
    @JsonProperty("ItemCategory")
    private String itemCategory;
    
    @JsonProperty("ItemPrice")
    private String itemPrice;
    
    @JsonProperty("ItemQty")
    private String itemQty;
    
    @JsonProperty("ItemSum")
    private String itemSum;
    
    @JsonProperty("ItemUom")
    private String itemUom;
    
    @JsonProperty("ItemSpecs")
    private String itemSpecs;
}
