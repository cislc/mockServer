package com.inspur.medical.controller;

import com.inspur.medical.dto.DepartmentInfoResponse;
import com.inspur.medical.entity.Department;
import com.inspur.medical.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class DepartmentInfoController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping("/department/info")
    public DepartmentInfoResponse getDepartmentInfo() {
        try {
            List<Department> departments = departmentRepository.findAll();
            return DepartmentInfoResponse.success(departments);
        } catch (Exception e) {
            return DepartmentInfoResponse.error("查询失败: " + e.getMessage());
        }
    }
}
