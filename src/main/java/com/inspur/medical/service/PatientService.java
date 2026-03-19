package com.inspur.medical.service;

import com.inspur.medical.dto.PatientQueryDTO;
import com.inspur.medical.dto.PatientSaveDTO;
import com.inspur.medical.entity.Patient;
import com.inspur.medical.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    private static final Random random = new Random();

    public List<Patient> searchPatient(PatientQueryDTO queryDTO) {
        List<Patient> results = new ArrayList<>();
        
        if (queryDTO.getCardNo() != null && !queryDTO.getCardNo().isEmpty()) {
            String cardType = queryDTO.getCardType();
            if ("0".equals(cardType)) {
                patientRepository.findByPatientCard(queryDTO.getCardNo()).ifPresent(results::add);
            } else if ("1".equals(cardType)) {
                patientRepository.findByIdNo(queryDTO.getCardNo()).ifPresent(results::add);
            }
        }
        
        return results;
    }

    @Transactional
    public Patient savePatient(PatientSaveDTO saveDTO) {
        Patient patient = new Patient();
        
        patient.setPatientID("P" + System.currentTimeMillis());
        patient.setPatientName(saveDTO.getPatientName());
        patient.setSex(saveDTO.getSex());
        patient.setSexCode(saveDTO.getSex().equals("男") ? "1" : "2");
        patient.setDob(saveDTO.getDob());
        patient.setAddress(saveDTO.getAddress());
        patient.setIdType(saveDTO.getIdType());
        patient.setIdTypeCode(saveDTO.getCardTypeCode());
        patient.setIdNo(saveDTO.getIdNo());
        patient.setMobile(saveDTO.getMobile());
        patient.setPatType(saveDTO.getPatientType());
        patient.setPatTypeCode("01");
        
        if (saveDTO.getPatientCard() != null && !saveDTO.getPatientCard().isEmpty()) {
            patient.setPatientCard(saveDTO.getPatientCard());
        } else {
            patient.setPatientCard("C" + String.format("%010d", random.nextInt(1000000000)));
        }
        
        patient.setYbFlag("0");
        patient.setAccInfo("账户");
        patient.setAccInfoBalance("0.00");
        patient.setAccInfoNo("ACC" + System.currentTimeMillis());
        patient.setDocumentID("DOC" + System.currentTimeMillis());
        patient.setInsureCardNo("");
        
        return patientRepository.save(patient);
    }

}
