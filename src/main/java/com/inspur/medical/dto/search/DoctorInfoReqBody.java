package com.inspur.medical.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DoctorInfoReqBody {
    @JsonProperty("DepartmentCode")
    private String departmentCode;
}
