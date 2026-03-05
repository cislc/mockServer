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

    @Transactional
    public void generateMockPatients(int count) {
        String[] surnames = {"张", "王", "李", "赵", "刘", "陈", "杨", "黄", "周", "吴"};
        String[] names = {"伟", "芳", "娜", "秀英", "敏", "静", "丽", "强", "磊", "军"};
        
        for (int i = 0; i < count; i++) {
            Patient patient = new Patient();
            
            String name = surnames[random.nextInt(surnames.length)] + 
                         names[random.nextInt(names.length)];
            
            patient.setPatientID("P" + String.format("%08d", 10000000 + i));
            patient.setPatientName(name);
            patient.setSexCode(random.nextBoolean() ? "1" : "2");
            patient.setSex(patient.getSexCode().equals("1") ? "男" : "女");
            patient.setDob(String.format("%d-%02d-%02d", 
                1950 + random.nextInt(60), 
                1 + random.nextInt(12), 
                1 + random.nextInt(28)));
            patient.setAddress("测试地址" + (i + 1));
            patient.setIdTypeCode("01");
            patient.setIdType("身份证");
            patient.setIdNo(String.format("3301%014d", random.nextLong() & Long.MAX_VALUE).substring(0, 18));
            patient.setMobile(String.format("1%010d", random.nextInt(1000000000)));
            patient.setPatType("自费");
            patient.setPatTypeCode("01");
            patient.setYbFlag("0");
            patient.setPatientCard("C" + String.format("%010d", 1000000000 + i));
            patient.setAccInfo("账户");
            patient.setAccInfoBalance(String.format("%.2f", random.nextDouble() * 1000));
            patient.setAccInfoNo("ACC" + String.format("%010d", i));
            patient.setDocumentID("DOC" + String.format("%010d", i));
            
            patientRepository.save(patient);
        }
    }
}
