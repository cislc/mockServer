package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inspur.medical.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentInfoResponse {
    
    @JsonProperty("ResultCode")
    private String resultCode;
    
    @JsonProperty("ResultContent")
    private String resultContent;
    
    @JsonProperty("Departments")
    private List<Department> departments;
    
    public static DepartmentInfoResponse success(List<Department> departments) {
        return new DepartmentInfoResponse("1", "查询成功", departments);
    }
    
    public static DepartmentInfoResponse error(String message) {
        return new DepartmentInfoResponse("0", message, null);
    }
}
