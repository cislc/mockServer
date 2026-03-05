package com.inspur.medical.controller;

import com.inspur.medical.dto.ApiResponse;
import com.inspur.medical.service.DoctorScheduleService;
import com.inspur.medical.service.ItemPriceService;
import com.inspur.medical.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search/generate")
public class DataInitController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private ItemPriceService itemPriceService;

    @Autowired
    private DoctorScheduleService scheduleService;

    @PostMapping("/patients")
    public ApiResponse<String> generatePatients(@RequestParam(defaultValue = "50") int count) {
        try {
            patientService.generateMockPatients(count);
            return ApiResponse.success("成功生成" + count + "个患者数据");
        } catch (Exception e) {
            return ApiResponse.error("生成患者数据失败: " + e.getMessage());
        }
    }

    @PostMapping("/prices")
    public ApiResponse<String> generatePrices() {
        try {
            itemPriceService.generateMockPrices();
            return ApiResponse.success("物价数据生成成功");
        } catch (Exception e) {
            return ApiResponse.error("生成物价数据失败: " + e.getMessage());
        }
    }
}
