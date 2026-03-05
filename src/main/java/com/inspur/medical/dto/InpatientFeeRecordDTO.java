package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InpatientFeeRecordDTO {
    
    @JsonProperty("Record")
    private String record;
    
    @JsonProperty("PayDate")
    private String payDate;
    
    @JsonProperty("PayTime")
    private String payTime;
    
    @JsonProperty("PayAmout")
    private String payAmout;
    
    @JsonProperty("PayMode")
    private String payMode;
    
    @JsonProperty("PayFlag")
    private String payFlag;
    
    @JsonProperty("ReceiptNo")
    private String receiptNo;
    
    @JsonProperty("PayUserCode")
    private String payUserCode;
    
    @JsonProperty("PayUserName")
    private String payUserName;
    
    @JsonProperty("PayDept")
    private String payDept;
    
    @JsonProperty("PayWard")
    private String payWard;
    
    @JsonProperty("Remark")
    private String remark;
}
