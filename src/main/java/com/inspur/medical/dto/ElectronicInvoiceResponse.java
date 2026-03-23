package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElectronicInvoiceResponse {
    
    @JsonProperty("ResultCode")
    private String resultCode;
    
    @JsonProperty("ResultContent")
    private String resultContent;
    
    @JsonProperty("LisInvoices")
    private List<ElectronicInvoiceDTO> lisInvoices;
    
    public static ElectronicInvoiceResponse success(List<ElectronicInvoiceDTO> lisInvoices) {
        return new ElectronicInvoiceResponse("0", "查询成功", lisInvoices);
    }
    
    public static ElectronicInvoiceResponse error(String message) {
        return new ElectronicInvoiceResponse("1", message, null);
    }
}
