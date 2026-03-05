package com.inspur.medical.controller;

import com.inspur.medical.dto.HospitalInfoResponse;
import com.inspur.medical.service.HospitalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
public class HospitalInfoController {

    @Autowired
    private HospitalInfoService hospitalInfoService;

    @PostMapping("/hospital/info")
    public HospitalInfoResponse getHospitalInfo() {
        try {
            String info = hospitalInfoService.getHospitalInfo();
            return HospitalInfoResponse.success(info);
        } catch (Exception e) {
            return HospitalInfoResponse.error("查询失败: " + e.getMessage());
        }
    }
}
