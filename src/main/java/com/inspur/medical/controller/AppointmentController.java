package com.inspur.medical.controller;

import com.inspur.medical.dto.AppointmentDTO;
import com.inspur.medical.dto.AppointmentQueryDTO;
import com.inspur.medical.dto.AppointmentResponse;
import com.inspur.medical.entity.Registration;
import com.inspur.medical.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/search")
public class AppointmentController {

    @Autowired
    private RegistrationRepository registrationRepository;

    @PostMapping("/appointment/pickupnumber")
    public AppointmentResponse getAppointmentPickupNumber(@RequestBody AppointmentQueryDTO queryDTO) {
        try {
            List<Registration> registrations = registrationRepository.findAll();
            List<AppointmentDTO> appointData = new ArrayList<>();
            
            for (Registration reg : registrations) {
                if ("REGISTERED".equals(reg.getStatus())) {
                    AppointmentDTO dto = new AppointmentDTO();
                    dto.setAdmitRange(reg.getAdmTime() != null ? reg.getAdmTime() + "-12:00" : "08:00-12:00");
                    dto.setRegFee(reg.getRegFee() != null ? reg.getRegFee() : "15.00");
                    dto.setAdmitAddress("门诊大楼2楼");
                    dto.setTransactionId(reg.getTransactionId());
                    dto.setApplID("APPL" + reg.getId());
                    dto.setDeptName("内科");
                    dto.setDoctorName(reg.getAdmDoc() != null ? reg.getAdmDoc() : "张明医生");
                    dto.setDoctorLevelDesc("主任医师");
                    dto.setDoctorLevelCode("P01");
                    appointData.add(dto);
                }
            }
            
            return AppointmentResponse.success(appointData);
        } catch (Exception e) {
            return AppointmentResponse.error("查询失败: " + e.getMessage());
        }
    }
}
