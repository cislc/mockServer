package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElectronicDocumentResponse {
    
    @JsonProperty("ResultCode")
    private String resultCode;
    
    @JsonProperty("ResultContent")
    private String resultContent;
    
    @JsonProperty("PatientID")
    private String patientID;
    
    @JsonProperty("PatientName")
    private String patientName;
    
    @JsonProperty("Sex")
    private String sex;
    
    @JsonProperty("CardType")
    private String cardType;
    
    @JsonProperty("PdfUrl")
    private String pdfUrl;
    
    public static ElectronicDocumentResponse success(String patientID, String patientName, 
                                                     String sex, String cardType, String pdfUrl) {
        return new ElectronicDocumentResponse("1", "查询成功", patientID, patientName, sex, cardType, pdfUrl);
    }
    
    public static ElectronicDocumentResponse error(String message) {
        return new ElectronicDocumentResponse("0", message, null, null, null, null, null);
    }
}
