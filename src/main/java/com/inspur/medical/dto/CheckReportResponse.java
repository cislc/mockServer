package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckReportResponse {
    
    @JsonProperty("ResultCode")
    private String resultCode;
    
    @JsonProperty("ResultContent")
    private String resultContent;
    
    @JsonProperty("LisReports")
    private List<CheckReportDTO> lisReports;
    
    public static CheckReportResponse success(List<CheckReportDTO> lisReports) {
        return new CheckReportResponse("1", "查询成功", lisReports);
    }
    
    public static CheckReportResponse error(String message) {
        return new CheckReportResponse("0", message, null);
    }
}
