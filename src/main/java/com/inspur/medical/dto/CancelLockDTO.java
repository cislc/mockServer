package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CancelLockDTO {
    @JsonProperty("ScheduleItemCode")
    private String scheduleItemCode;
    
    @JsonProperty("TransactionId")
    private String transactionId;
    
    @JsonProperty("LockQueueNo")
    private String lockQueueNo;
}
