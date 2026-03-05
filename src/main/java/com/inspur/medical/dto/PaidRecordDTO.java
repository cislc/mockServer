package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaidRecordDTO {
    
    @JsonProperty("OrderNo")
    private String orderNo;
    
    @JsonProperty("InvoiceNo")
    private String invoiceNo;
    
    @JsonProperty("InvDate")
    private String invDate;
    
    @JsonProperty("InvTime")
    private String invTime;
    
    @JsonProperty("TotalAmt")
    private String totalAmt;
    
    @JsonProperty("InsuShareAmt")
    private String insuShareAmt;
    
    @JsonProperty("PatShareAmt")
    private String patShareAmt;
    
    @JsonProperty("PayModelInfo")
    private String payModelInfo;
    
    @JsonProperty("AdmDate")
    private String admDate;
}
