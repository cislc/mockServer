package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeslotResponse {
    
    @JsonProperty("ResultCode")
    private String resultCode;
    
    @JsonProperty("ResultContent")
    private String resultContent;
    
    @JsonProperty("TimeRanges")
    private List<TimeslotDTO> timeRanges;
    
    public static TimeslotResponse success(List<TimeslotDTO> timeRanges) {
        return new TimeslotResponse("1", "查询成功", timeRanges);
    }
    
    public static TimeslotResponse error(String message) {
        return new TimeslotResponse("0", message, null);
    }
}
