package com.inspur.medical.controller;

import com.inspur.medical.dto.InpatientDTO;
import com.inspur.medical.dto.InpatientFeeQueryDTO;
import com.inspur.medical.dto.InpatientFeeRecordDTO;
import com.inspur.medical.dto.InpatientFeeResponse;
import com.inspur.medical.dto.InpatientQueryDTO;
import com.inspur.medical.dto.InpatientRechargeDTO;
import com.inspur.medical.dto.InpatientRechargeResponse;
import com.inspur.medical.dto.InpatientResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
public class InpatientController {

    private static final Random random = new Random();

    @PostMapping("/search/inpatient")
    public InpatientResponse searchInpatient(@RequestBody InpatientQueryDTO queryDTO) {
        try {
            List<InpatientDTO> inpatients = new ArrayList<>();
            
            InpatientDTO inpatient = new InpatientDTO();
            inpatient.setPatientID("P00001");
            inpatient.setPatientName("李四");
            inpatient.setSex("男");
            inpatient.setDob("1980-05-15");
            inpatient.setMedical("MED" + System.currentTimeMillis());
            inpatient.setCardType("01");
            inpatient.setCardNo("330106198005150012");
            inpatient.setAdmInfoList("住院信息列表");
            inpatient.setAdmID("ADM" + System.currentTimeMillis());
            inpatient.setAdmDate("2024-01-10");
            inpatient.setAdmDept("外科");
            inpatient.setBillNo("BILL" + System.currentTimeMillis());
            inpatient.setAdmReason("手术治疗");
            inpatient.setNationalCode("1");
            inpatient.setTotalAmount("5000.00");
            inpatient.setDepositAmount("3000.00");
            inpatient.setDepositBalance("2000.00");
            inpatients.add(inpatient);
            
            return InpatientResponse.success(inpatients);
        } catch (Exception e) {
            return InpatientResponse.error("查询失败: " + e.getMessage());
        }
    }

    @PostMapping("/recharge/inpatient")
    public InpatientRechargeResponse rechargeInpatient(@RequestBody InpatientRechargeDTO rechargeDTO) {
        try {
            String serialNo = "SN" + System.currentTimeMillis();
            double rechargeAmt = Double.parseDouble(rechargeDTO.getPayAmt());
            double currentBalance = 2000 + random.nextDouble() * 3000;
            double newBalance = currentBalance + rechargeAmt;
            
            return InpatientRechargeResponse.success(serialNo, 
                                                    String.format("%.2f", rechargeAmt),
                                                    String.format("%.2f", newBalance));
        } catch (Exception e) {
            return InpatientRechargeResponse.error("充值失败: " + e.getMessage());
        }
    }

    @PostMapping("/search/inpatientfee")
    public InpatientFeeResponse getInpatientFee(@RequestBody InpatientFeeQueryDTO queryDTO) {
        try {
            List<InpatientFeeRecordDTO> recordList = new ArrayList<>();
            
            InpatientFeeRecordDTO record1 = new InpatientFeeRecordDTO("床位费", "2024-01-15", "10:00:00", 
                                                                       "80.00", "现金", "已缴费", "RCP001", 
                                                                       "U001", "张护士", "外科", "A区", "床位费用");
            InpatientFeeRecordDTO record2 = new InpatientFeeRecordDTO("药品费", "2024-01-14", "14:30:00", 
                                                                       "150.00", "微信支付", "已缴费", "RCP002", 
                                                                       "U002", "李护士", "外科", "A区", "药品费用");
            recordList.add(record1);
            recordList.add(record2);
            
            return InpatientFeeResponse.success(recordList);
        } catch (Exception e) {
            return InpatientFeeResponse.error("查询失败: " + e.getMessage());
        }
    }
}
