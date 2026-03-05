package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElectronicInvoiceDTO {
    
    @JsonProperty("PayId")
    private String payId;
    
    @JsonProperty("BizCode")
    private String bizCode;
    
    @JsonProperty("EInvoiceNumber")
    private String eInvoiceNumber;
    
    @JsonProperty("EInvoiceCode")
    private String eInvoiceCode;
    
    @JsonProperty("RandomNumber")
    private String randomNumber;
    
    @JsonProperty("PrintFlag")
    private String printFlag;
    
    @JsonProperty("InvoiceUrl")
    private String invoiceUrl;
    
    @JsonProperty("InvoiceDate")
    private String invoiceDate;
}
