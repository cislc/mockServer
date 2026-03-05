package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TimeslotQueryDTO {
    @JsonProperty("DepartmentCode")
    private String departmentCode;
    
    @JsonProperty("DoctorCode")
    private String doctorCode;
    
    @JsonProperty("RBASSesionCode")
    private String rbasSessionCode;
    
    @JsonProperty("ServiceDate")
    private String serviceDate;
}
