package com.inspur.medical.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inspur.medical.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentInfoResBody {
    @JsonProperty("ResultCode")
    private Integer resultCode;
    
    @JsonProperty("ResultContent")
    private String resultContent;
    
    @JsonProperty("Departments")
    private List<Department> departments;
    
    public static DepartmentInfoResBody success(List<Department> departments) {
        return new DepartmentInfoResBody(0, "成功", departments);
    }
    
    public static DepartmentInfoResBody error(String message) {
        return new DepartmentInfoResBody(1, message, null);
    }
}
