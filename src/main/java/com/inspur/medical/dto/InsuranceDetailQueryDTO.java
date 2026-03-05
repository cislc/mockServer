package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InsuranceDetailQueryDTO {
    @JsonProperty("OrderNo")
    private String orderNo;
    
    @JsonProperty("mipaycode")
    private String mipaycode;
}
