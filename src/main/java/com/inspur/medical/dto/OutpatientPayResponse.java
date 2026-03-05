package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutpatientPayResponse {
    
    @JsonProperty("ResultCode")
    private String resultCode;
    
    @JsonProperty("ResultContent")
    private String resultContent;
    
    public static OutpatientPayResponse success() {
        return new OutpatientPayResponse("1", "缴费成功");
    }
    
    public static OutpatientPayResponse error(String message) {
        return new OutpatientPayResponse("0", message);
    }
}
