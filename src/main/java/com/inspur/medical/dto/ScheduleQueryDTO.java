package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ScheduleQueryDTO {
    @JsonProperty("DepartmentCode")
    private String departmentCode;
    
    @JsonProperty("DoctorCode")
    private String doctorCode;
    
    @JsonProperty("StartDate")
    private String startDate;
    
    @JsonProperty("EndDate")
    private String endDate;
}
