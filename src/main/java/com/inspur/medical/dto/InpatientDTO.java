package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InpatientDTO {
    
    @JsonProperty("PatientID")
    private String patientID;
    
    @JsonProperty("PatientName")
    private String patientName;
    
    @JsonProperty("Sex")
    private String sex;
    
    @JsonProperty("DOB")
    private String dob;
    
    @JsonProperty("Medical")
    private String medical;
    
    @JsonProperty("CardType")
    private String cardType;
    
    @JsonProperty("CardNo")
    private String cardNo;
    
    @JsonProperty("AdmInfoList")
    private String admInfoList;
    
    @JsonProperty("AdmID")
    private String admID;
    
    @JsonProperty("AdmDate")
    private String admDate;
    
    @JsonProperty("AdmDept")
    private String admDept;
    
    @JsonProperty("BillNo")
    private String billNo;
    
    @JsonProperty("AdmReason")
    private String admReason;
    
    @JsonProperty("NationalCode")
    private String nationalCode;
    
    @JsonProperty("TotalAmount")
    private String totalAmount;
    
    @JsonProperty("DepositAmount")
    private String depositAmount;
    
    @JsonProperty("DepositBalance")
    private String depositBalance;
}
