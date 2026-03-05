package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemPriceQueryDTO {
    @JsonProperty("ItemType")
    private String itemType;
    
    @JsonProperty("Alias")
    private String alias;
}
