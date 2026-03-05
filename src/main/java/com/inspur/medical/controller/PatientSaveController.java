package com.inspur.medical.controller;

import com.inspur.medical.dto.PatientSaveDTO;
import com.inspur.medical.dto.PatientSaveResponse;
import com.inspur.medical.entity.Patient;
import com.inspur.medical.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/save")
public class PatientSaveController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/patient")
    public PatientSaveResponse savePatient(@RequestBody PatientSaveDTO saveDTO) {
        try {
            Patient patient = patientService.savePatient(saveDTO);
            return PatientSaveResponse.success(patient.getPatientCard(), patient.getPatientID());
        } catch (Exception e) {
            return PatientSaveResponse.error("建档失败: " + e.getMessage());
        }
    }
}
