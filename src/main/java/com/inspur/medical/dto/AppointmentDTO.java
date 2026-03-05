package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {
    
    @JsonProperty("AdmitRange")
    private String admitRange;
    
    @JsonProperty("RegFee")
    private String regFee;
    
    @JsonProperty("AdmitAddress")
    private String admitAddress;
    
    @JsonProperty("TransactionId")
    private String transactionId;
    
    @JsonProperty("ApplID")
    private String applID;
    
    @JsonProperty("DeptName")
    private String deptName;
    
    @JsonProperty("DoctorName")
    private String doctorName;
    
    @JsonProperty("DoctorLevelDesc")
    private String doctorLevelDesc;
    
    @JsonProperty("DoctorLevelCode")
    private String doctorLevelCode;
}
