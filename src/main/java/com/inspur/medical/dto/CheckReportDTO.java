package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckReportDTO {
    
    @JsonProperty("VisitNumberReportID")
    private String visitNumberReportID;
    
    @JsonProperty("AddDate")
    private String addDate;
    
    @JsonProperty("AddTime")
    private String addTime;
    
    @JsonProperty("PDFPath")
    private String pdfPath;
    
    @JsonProperty("TestSetName")
    private String testSetName;
    
    @JsonProperty("PrintFlag")
    private String printFlag;
    
    @JsonProperty("LabNo")
    private String labNo;
}
