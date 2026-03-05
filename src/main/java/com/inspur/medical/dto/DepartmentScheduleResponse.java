package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentScheduleResponse {
    
    @JsonProperty("ResultCode")
    private String resultCode;
    
    @JsonProperty("ResultContent")
    private String resultContent;
    
    @JsonProperty("Departments")
    private List<DepartmentScheduleDTO> departments;
    
    public static DepartmentScheduleResponse success(List<DepartmentScheduleDTO> departments) {
        return new DepartmentScheduleResponse("1", "查询成功", departments);
    }
    
    public static DepartmentScheduleResponse error(String message) {
        return new DepartmentScheduleResponse("0", message, null);
    }
}
