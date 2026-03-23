package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrintStatusResponse {
    @JsonProperty("ResultCode")
    private String resultCode;
    
    @JsonProperty("ResultContent")
    private String resultContent;

    public static PrintStatusResponse success() {
        return new PrintStatusResponse("0", "成功");
    }

    public static PrintStatusResponse error(String message) {
        return new PrintStatusResponse("1", message);
    }
}
