package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DoctorQueryDTO {
    @JsonProperty("DepartmentCode")
    private String departmentCode;
}
