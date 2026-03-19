package com.inspur.medical.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inspur.medical.entity.ItemPrice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPriceResBody {
    @JsonProperty("ResultCode")
    private Integer resultCode;
    
    @JsonProperty("ResultContent")
    private String resultContent;
    
    @JsonProperty("TarItemS")
    private List<ItemPrice> tarItems;
    
    public static ItemPriceResBody success(List<ItemPrice> items) {
        return new ItemPriceResBody(0, "成功", items);
    }
    
    public static ItemPriceResBody error(String message) {
        return new ItemPriceResBody(1, message, null);
    }
}
