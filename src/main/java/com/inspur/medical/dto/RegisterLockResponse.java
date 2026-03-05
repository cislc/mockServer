package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterLockResponse {
    
    @JsonProperty("ResultCode")
    private String resultCode;
    
    @JsonProperty("ResultContent")
    private String resultContent;
    
    @JsonProperty("LockQueueNo")
    private String lockQueueNo;
    
    @JsonProperty("ScheduleItemCode")
    private String scheduleItemCode;
    
    @JsonProperty("AdmDoc")
    private String admDoc;
    
    @JsonProperty("AdmDate")
    private String admDate;
    
    @JsonProperty("AdmTime")
    private String admTime;
    
    @JsonProperty("RegFee")
    private String regFee;
    
    @JsonProperty("TransactionId")
    private String transactionId;
    
    public static RegisterLockResponse success(String lockQueueNo, String scheduleItemCode, 
                                                String admDoc, String admDate, String admTime, 
                                                String regFee, String transactionId) {
        return new RegisterLockResponse("1", "锁号成功", lockQueueNo, scheduleItemCode, 
                                        admDoc, admDate, admTime, regFee, transactionId);
    }
    
    public static RegisterLockResponse error(String message) {
        return new RegisterLockResponse("0", message, null, null, null, null, null, null, null);
    }
}
