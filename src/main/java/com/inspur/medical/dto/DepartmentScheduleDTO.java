package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentScheduleDTO {
    
    @JsonProperty("DepartmentName")
    private String departmentName;
    
    @JsonProperty("RecordCount")
    private String recordCount;
    
    @JsonProperty("ParentId")
    private String parentId;
    
    @JsonProperty("Description")
    private String description;
    
    @JsonProperty("DepartmentAddress")
    private String departmentAddress;
    
    @JsonProperty("DepartmentAgeLimit")
    private String departmentAgeLimit;
}
