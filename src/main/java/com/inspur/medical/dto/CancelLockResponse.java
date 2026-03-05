package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CancelLockResponse {
    
    @JsonProperty("ResultCode")
    private String resultCode;
    
    @JsonProperty("ResultContent")
    private String resultContent;
    
    public static CancelLockResponse success() {
        return new CancelLockResponse("1", "取消锁号成功");
    }
    
    public static CancelLockResponse error(String message) {
        return new CancelLockResponse("0", message);
    }
}
