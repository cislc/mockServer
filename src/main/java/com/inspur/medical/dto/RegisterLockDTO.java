package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RegisterLockDTO {
    @JsonProperty("PatientID")
    private String patientID;
    
    @JsonProperty("ScheduleItemCode")
    private String scheduleItemCode;
    
    @JsonProperty("CardNo")
    private String cardNo;
    
    @JsonProperty("CardType")
    private String cardType;
    
    @JsonProperty("CredTypeCode")
    private String credTypeCode;
    
    @JsonProperty("IDCardNo")
    private String idCardNo;
    
    @JsonProperty("TransactionId")
    private String transactionId;
    
    @JsonProperty("OldTransactionId")
    private String oldTransactionId;
    
    @JsonProperty("LockQueueNo")
    private String lockQueueNo;
    
    @JsonProperty("Mobile")
    private String mobile;
    
    @JsonProperty("PayOrdId")
    private String payOrdId;
    
    @JsonProperty("BeginTime")
    private String beginTime;
    
    @JsonProperty("EndTime")
    private String endTime;
}
