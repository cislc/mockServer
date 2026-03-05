package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inspur.medical.entity.ItemPrice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPriceResponse {
    
    @JsonProperty("ResultCode")
    private String resultCode;
    
    @JsonProperty("ResultContent")
    private String resultContent;
    
    @JsonProperty("TarItemS")
    private List<ItemPrice> tarItemS;
    
    public static ItemPriceResponse success(List<ItemPrice> items) {
        return new ItemPriceResponse("1", "查询成功", items);
    }
    
    public static ItemPriceResponse error(String message) {
        return new ItemPriceResponse("0", message, null);
    }
}
