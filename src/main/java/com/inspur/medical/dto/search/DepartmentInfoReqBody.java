package com.inspur.medical.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DepartmentInfoReqBody {
    @JsonProperty("DepartmentCode")
    private String departmentCode;
    @JsonProperty("DepartmentName")
    private String departmentName;
}
