package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotPayResponse {
    
    @JsonProperty("ResultCode")
    private String resultCode;
    
    @JsonProperty("ResultContent")
    private String resultContent;
    
    @JsonProperty("PayOrdCount")
    private String payOrdCount;
    
    @JsonProperty("PayOrdList")
    private List<PayOrderDTO> payOrdList;
    
    public static NotPayResponse success(List<PayOrderDTO> payOrdList) {
        return new NotPayResponse("1", "查询成功", String.valueOf(payOrdList.size()), payOrdList);
    }
    
    public static NotPayResponse error(String message) {
        return new NotPayResponse("0", message, "0", null);
    }
}
