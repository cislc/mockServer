package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResponse {
    
    @JsonProperty("ResultCode")
    private String resultCode;
    
    @JsonProperty("ResultContent")
    private String resultContent;
    
    @JsonProperty("AppointData")
    private List<AppointmentDTO> appointData;
    
    public static AppointmentResponse success(List<AppointmentDTO> appointData) {
        return new AppointmentResponse("1", "查询成功", appointData);
    }
    
    public static AppointmentResponse error(String message) {
        return new AppointmentResponse("0", message, null);
    }
}
