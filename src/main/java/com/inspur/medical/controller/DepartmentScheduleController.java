package com.inspur.medical.controller;

import com.inspur.medical.dto.DepartmentScheduleDTO;
import com.inspur.medical.dto.DepartmentScheduleQueryDTO;
import com.inspur.medical.dto.DepartmentScheduleResponse;
import com.inspur.medical.entity.Department;
import com.inspur.medical.repository.DepartmentRepository;
import com.inspur.medical.repository.DoctorScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/search")
public class DepartmentScheduleController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DoctorScheduleRepository scheduleRepository;

    @PostMapping("/department")
    public DepartmentScheduleResponse getDepartmentSchedule(@RequestBody DepartmentScheduleQueryDTO queryDTO) {
        try {
            List<Department> departments = departmentRepository.findAll();
            List<DepartmentScheduleDTO> deptList = new ArrayList<>();

            for (Department dept : departments) {
                long count = scheduleRepository.countByDepartmentCode(dept.getDepartmentCode());

                DepartmentScheduleDTO dto = new DepartmentScheduleDTO();
                dto.setDepartmentName(dept.getDepartmentName());
                dto.setDepartmentCode(dept.getDepartmentCode());
                dto.setScheduleFlag(1);
                dto.setRecordCount(String.valueOf(count));
                dto.setParentId("-1");
                dto.setDescription(
                        dept.getDepartmentDes() != null ? dept.getDepartmentDes() : dept.getDepartmentName() + "专业诊疗");
                dto.setDepartmentAddress(dept.getDepartmentName() + "门诊");
                dto.setDepartmentAgeLimit("无限制");
                deptList.add(dto);
            }

            return DepartmentScheduleResponse.success(deptList);
        } catch (Exception e) {
            return DepartmentScheduleResponse.error("查询失败: " + e.getMessage());
        }
    }
}
