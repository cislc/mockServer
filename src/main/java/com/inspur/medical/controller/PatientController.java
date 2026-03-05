package com.inspur.medical.controller;

import com.inspur.medical.dto.PatientQueryDTO;
import com.inspur.medical.dto.PatientResponse;
import com.inspur.medical.entity.Patient;
import com.inspur.medical.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/outpatient")
    public PatientResponse searchPatient(@RequestBody PatientQueryDTO queryDTO) {
        try {
            List<Patient> patients = patientService.searchPatient(queryDTO);
            return PatientResponse.success(patients);
        } catch (Exception e) {
            return PatientResponse.error("查询失败: " + e.getMessage());
        }
    }
}
