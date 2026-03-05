package com.inspur.medical.controller;

import com.inspur.medical.dto.HisAccountQueryDTO;
import com.inspur.medical.dto.HisAccountResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
public class ReconciliationController {

    @PostMapping("/getHisAccount")
    public HisAccountResponse getHisAccount(@RequestBody HisAccountQueryDTO queryDTO) {
        try {
            return HisAccountResponse.success("INV" + System.currentTimeMillis(),
                                             "MER001",
                                             "OP",
                                             queryDTO.getPayType() != null ? queryDTO.getPayType() : "01",
                                             "150.00",
                                             "挂号",
                                             queryDTO.getStartDate(),
                                             queryDTO.getUserCode(),
                                             queryDTO.getTransNo() != null ? queryDTO.getTransNo() : "TXN" + System.currentTimeMillis(),
                                             "已支付",
                                             "P00001",
                                             "张三");
        } catch (Exception e) {
            return HisAccountResponse.error("查询失败: " + e.getMessage());
        }
    }
}
