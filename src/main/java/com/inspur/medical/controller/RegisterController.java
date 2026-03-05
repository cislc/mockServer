package com.inspur.medical.controller;

import com.inspur.medical.dto.CancelLockDTO;
import com.inspur.medical.dto.CancelLockResponse;
import com.inspur.medical.dto.RegisterDTO;
import com.inspur.medical.dto.RegisterLockDTO;
import com.inspur.medical.dto.RegisterLockResponse;
import com.inspur.medical.dto.RegisterResponse;
import com.inspur.medical.entity.Registration;
import com.inspur.medical.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegistrationRepository registrationRepository;

    @PostMapping("/rgstLock")
    public RegisterLockResponse lockRegistration(@RequestBody RegisterLockDTO lockDTO) {
        try {
            String lockQueueNo = "LQ" + System.currentTimeMillis();
            String transactionId = lockDTO.getTransactionId() != null ? 
                                  lockDTO.getTransactionId() : "TXN" + System.currentTimeMillis();
            
            Registration registration = new Registration();
            registration.setPatientID(lockDTO.getPatientID());
            registration.setScheduleItemCode(lockDTO.getScheduleItemCode());
            registration.setLockQueueNo(lockQueueNo);
            registration.setCardNo(lockDTO.getCardNo());
            registration.setTransactionId(transactionId);
            registration.setAdmDoc("DOC001");
            registration.setAdmDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            registration.setAdmTime(lockDTO.getBeginTime() != null ? lockDTO.getBeginTime() : "08:00");
            registration.setRegFee("15.00");
            registration.setStatus("LOCKED");
            
            registrationRepository.save(registration);
            
            return RegisterLockResponse.success(lockQueueNo, lockDTO.getScheduleItemCode(), 
                                                "DOC001", registration.getAdmDate(), 
                                                registration.getAdmTime(), "15.00", transactionId);
        } catch (Exception e) {
            return RegisterLockResponse.error("锁号失败: " + e.getMessage());
        }
    }

    @PostMapping("/cancelRgst")
    public CancelLockResponse cancelRegistration(@RequestBody CancelLockDTO cancelDTO) {
        try {
            if (cancelDTO.getLockQueueNo() != null && !cancelDTO.getLockQueueNo().isEmpty()) {
                registrationRepository.findByLockQueueNo(cancelDTO.getLockQueueNo())
                    .ifPresent(reg -> {
                        reg.setStatus("CANCELLED");
                        registrationRepository.save(reg);
                    });
            } else if (cancelDTO.getTransactionId() != null && !cancelDTO.getTransactionId().isEmpty()) {
                registrationRepository.findByTransactionId(cancelDTO.getTransactionId())
                    .ifPresent(reg -> {
                        reg.setStatus("CANCELLED");
                        registrationRepository.save(reg);
                    });
            }
            return CancelLockResponse.success();
        } catch (Exception e) {
            return CancelLockResponse.error("取消锁号失败: " + e.getMessage());
        }
    }

    @PostMapping("/rgst")
    public RegisterResponse register(@RequestBody RegisterDTO registerDTO) {
        try {
            String seqCode = registerDTO.getQueueNo() != null ? registerDTO.getQueueNo() : String.valueOf(1 + (int)(Math.random() * 50));
            String admNo = "ADM" + System.currentTimeMillis();
            String receiptNo = "RCP" + System.currentTimeMillis();
            String applID = "APPL" + System.currentTimeMillis();
            String hisTradeOrderId = "HIS" + System.currentTimeMillis();
            
            Registration registration = registrationRepository.findByLockQueueNo(registerDTO.getQueueNo())
                .orElse(new Registration());
            
            registration.setStatus("REGISTERED");
            registration.setPatientID(registerDTO.getPatientID());
            registration.setScheduleItemCode(registerDTO.getScheduleItemCode());
            registration.setCardNo(registerDTO.getPatientCard());
            registration.setTransactionId(registerDTO.getPayTradeNo());
            registration.setRegFee(registerDTO.getPayFee());
            registrationRepository.save(registration);
            
            return RegisterResponse.success(seqCode, "08:00-12:00", registerDTO.getPayFee(),
                                           "门诊大楼2楼", registerDTO.getPayTradeNo(), applID,
                                           registerDTO.getPayOrderId(), admNo, "内科", "张明医生",
                                           "主任医师", "P01", receiptNo, "上午", hisTradeOrderId);
        } catch (Exception e) {
            return RegisterResponse.error("挂号失败: " + e.getMessage());
        }
    }
}
