package com.inspur.medical.controller;

import com.inspur.medical.dto.NotPayQueryDTO;
import com.inspur.medical.dto.NotPayResponse;
import com.inspur.medical.dto.OutpatientPayDTO;
import com.inspur.medical.dto.OutpatientPayResponse;
import com.inspur.medical.dto.PaidRecordDTO;
import com.inspur.medical.dto.PaidRecordQueryDTO;
import com.inspur.medical.dto.PaidRecordResponse;
import com.inspur.medical.dto.PayItemDTO;
import com.inspur.medical.dto.PayOrderDTO;
import com.inspur.medical.dto.RechargeDTO;
import com.inspur.medical.dto.RechargeResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
public class PaymentController {

    private static final Random random = new Random();

    @PostMapping("/search/notpay")
    public NotPayResponse getNotPayInfo(@RequestBody NotPayQueryDTO queryDTO) {
        try {
            List<PayOrderDTO> payOrdList = new ArrayList<>();
            
            PayOrderDTO order = new PayOrderDTO();
            order.setOrderNo("ORD" + System.currentTimeMillis());
            order.setOrderSum("60.00");
            order.setOrderInsuFlag(0);
            order.setOrdInsuData("");
            order.setOrderInsType("自费");
            
            List<PayItemDTO> itemList = new ArrayList<>();
            PayItemDTO item1 = new PayItemDTO("血常规", "ITEM0001", "血常规", "检验", "25.00", "1", "25.00", "次", "");
            PayItemDTO item2 = new PayItemDTO("尿常规", "ITEM0002", "尿常规", "检验", "20.00", "1", "20.00", "次", "");
            PayItemDTO item3 = new PayItemDTO("诊查费", "ITEM0010", "诊查费", "诊疗", "15.00", "1", "15.00", "次", "");
            itemList.add(item1);
            itemList.add(item2);
            itemList.add(item3);
            
            order.setItemList(itemList);
            payOrdList.add(order);
            
            return NotPayResponse.success(payOrdList);
        } catch (Exception e) {
            return NotPayResponse.error("查询失败: " + e.getMessage());
        }
    }

    @PostMapping("/pay/outpatient")
    public OutpatientPayResponse payOutpatient(@RequestBody OutpatientPayDTO payDTO) {
        try {
            return OutpatientPayResponse.success();
        } catch (Exception e) {
            return OutpatientPayResponse.error("缴费失败: " + e.getMessage());
        }
    }

    @PostMapping("/recharge/outpatient")
    public RechargeResponse rechargeOutpatient(@RequestBody RechargeDTO rechargeDTO) {
        try {
            String serialNo = "SN" + System.currentTimeMillis();
            String accountID = "ACC" + rechargeDTO.getPatientId();
            double beforeBal = 100 + random.nextDouble() * 500;
            double rechargeAmt = Double.parseDouble(rechargeDTO.getPayAmt());
            double afterBal = beforeBal + rechargeAmt;
            
            return RechargeResponse.success(serialNo, accountID, 
                                           String.format("%.2f", beforeBal),
                                           String.format("%.2f", afterBal),
                                           "10000.00");
        } catch (Exception e) {
            return RechargeResponse.error("充值失败: " + e.getMessage());
        }
    }

    @PostMapping("/search/paidrecord")
    public PaidRecordResponse getPaidRecord(@RequestBody PaidRecordQueryDTO queryDTO) {
        try {
            List<PaidRecordDTO> recordList = new ArrayList<>();
            java.time.LocalDate today = java.time.LocalDate.now();
            java.time.format.DateTimeFormatter dateFormatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd");
            
            PaidRecordDTO record1 = new PaidRecordDTO("ORD" + System.currentTimeMillis(), 
                                                       "INV" + System.currentTimeMillis(),
                                                       today.format(dateFormatter), "09:30:00", "285.50", 
                                                       "150.00", "135.50", "医保及微信统筹", today.format(dateFormatter));
            PaidRecordDTO record2 = new PaidRecordDTO("ORD" + (System.currentTimeMillis() - 86400000), 
                                                       "INV" + (System.currentTimeMillis() - 86400000),
                                                       today.minusDays(1).format(dateFormatter), "14:20:00", "45.00", 
                                                       "0.00", "45.00", "支付宝", today.minusDays(1).format(dateFormatter));
            PaidRecordDTO record3 = new PaidRecordDTO("ORD" + (System.currentTimeMillis() - 172800000), 
                                                       "INV" + (System.currentTimeMillis() - 172800000),
                                                       today.minusDays(2).format(dateFormatter), "10:15:00", "560.00", 
                                                       "300.00", "260.00", "医保卡单边扣", today.minusDays(2).format(dateFormatter));
            PaidRecordDTO record4 = new PaidRecordDTO("ORD" + (System.currentTimeMillis() - 259200000), 
                                                       "INV" + (System.currentTimeMillis() - 259200000),
                                                       today.minusDays(3).format(dateFormatter), "16:45:00", "15.00", 
                                                       "0.00", "15.00", "微信支付", today.minusDays(3).format(dateFormatter));
            PaidRecordDTO record5 = new PaidRecordDTO("ORD" + (System.currentTimeMillis() - 604800000), 
                                                       "INV" + (System.currentTimeMillis() - 604800000),
                                                       today.minusDays(7).format(dateFormatter), "11:00:00", "1250.00", 
                                                       "800.00", "450.00", "银联银行卡", today.minusDays(7).format(dateFormatter));

            recordList.add(record1);
            recordList.add(record2);
            recordList.add(record3);
            recordList.add(record4);
            recordList.add(record5);
            
            return PaidRecordResponse.success(recordList);
        } catch (Exception e) {
            return PaidRecordResponse.error("查询失败: " + e.getMessage());
        }
    }
}
