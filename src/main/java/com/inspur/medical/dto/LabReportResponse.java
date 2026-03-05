package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LabReportResponse {
    
    @JsonProperty("ResultCode")
    private String resultCode;
    
    @JsonProperty("ResultContent")
    private String resultContent;
    
    @JsonProperty("LisReports")
    private List<LabReportDTO> lisReports;
    
    public static LabReportResponse success(List<LabReportDTO> lisReports) {
        return new LabReportResponse("1", "查询成功", lisReports);
    }
    
    public static LabReportResponse error(String message) {
        return new LabReportResponse("0", message, null);
    }
}
