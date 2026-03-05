package com.inspur.medical.service;

import com.inspur.medical.entity.HospitalInfo;
import com.inspur.medical.repository.HospitalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalInfoService {

    @Autowired
    private HospitalInfoRepository hospitalInfoRepository;

    public String getHospitalInfo() {
        List<HospitalInfo> hospitals = hospitalInfoRepository.findAll();
        if (!hospitals.isEmpty()) {
            HospitalInfo hospital = hospitals.get(0);
            StringBuilder info = new StringBuilder();
            info.append("医院名称：").append(hospital.getHospitalName()).append("\n");
            info.append("医院等级：").append(hospital.getHospitalLevel()).append("\n");
            info.append("医院类型：").append(hospital.getHospitalType()).append("\n");
            info.append("医院地址：").append(hospital.getAddress()).append("\n");
            info.append("联系电话：").append(hospital.getPhone()).append("\n");
            info.append("官方网站：").append(hospital.getWebsite()).append("\n");
            info.append("营业时间：").append(hospital.getBusinessHours()).append("\n");
            info.append("医院简介：").append(hospital.getIntroduction());
            return info.toString();
        }
        return "暂无医院信息";
    }
}
