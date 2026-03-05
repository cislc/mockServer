package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayOrderDTO {
    
    @JsonProperty("OrderNo")
    private String orderNo;
    
    @JsonProperty("OrderSum")
    private String orderSum;
    
    @JsonProperty("OrderInsuFlag")
    private Integer orderInsuFlag;
    
    @JsonProperty("OrdInsuData")
    private String ordInsuData;
    
    @JsonProperty("OrderInsType")
    private String orderInsType;
    
    @JsonProperty("ItemList")
    private List<PayItemDTO> itemList;
}
