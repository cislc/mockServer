package com.inspur.medical.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemPriceReqBody {
    @JsonProperty("ItemType")
    private String itemType;
    
    @JsonProperty("Alias")
    private String alias;
}
