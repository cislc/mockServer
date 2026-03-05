package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceDiseInfoDTO {
    @JsonProperty("diag_type")
    private String diagType;
    
    @JsonProperty("diag_str_no")
    private String diagStrNo;
    
    @JsonProperty("diag_code")
    private String diagCode;
    
    @JsonProperty("diag_name")
    private String diagName;
    
    @JsonProperty("diag_dept")
    private String diagDept;
    
    @JsonProperty("dise_dor_no")
    private String diseDorNo;
    
    @JsonProperty("dise_dor_name")
    private String diseDorName;
    
    @JsonProperty("diag_time")
    private String diagTime;
    
    @JsonProperty("vali_flag")
    private String valiFlag;
}
