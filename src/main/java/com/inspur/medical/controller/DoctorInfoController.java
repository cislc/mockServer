package com.inspur.medical.controller;

import com.inspur.medical.dto.DoctorInfoResponse;
import com.inspur.medical.dto.DoctorQueryDTO;
import com.inspur.medical.entity.Doctor;
import com.inspur.medical.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class DoctorInfoController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping("/doctor/info")
    public DoctorInfoResponse getDoctorInfo(@RequestBody DoctorQueryDTO queryDTO) {
        try {
            List<Doctor> doctors;
            if (queryDTO.getDepartmentCode() != null && !queryDTO.getDepartmentCode().isEmpty()) {
                doctors = doctorRepository.findByDepartmentCode(queryDTO.getDepartmentCode());
            } else {
                doctors = doctorRepository.findAll();
            }
            return DoctorInfoResponse.success(doctors);
        } catch (Exception e) {
            return DoctorInfoResponse.error("查询失败: " + e.getMessage());
        }
    }
}
