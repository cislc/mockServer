package com.inspur.medical.controller;

import com.inspur.medical.dto.search.*;
import com.inspur.medical.entity.Department;
import com.inspur.medical.entity.Doctor;
import com.inspur.medical.entity.ItemPrice;
import com.inspur.medical.repository.DepartmentRepository;
import com.inspur.medical.repository.DoctorRepository;
import com.inspur.medical.service.HospitalInfoService;
import com.inspur.medical.service.ItemPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class InfoSearchController {

    @Autowired
    private ItemPriceService itemPriceService;

    @Autowired
    private HospitalInfoService hospitalInfoService;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping("/item/price")
    public ItemPriceResBody searchItemPrice(@RequestBody ItemPriceReqBody body) {
        try {
            List<ItemPrice> prices = itemPriceService.searchItemPrice(
                    body != null ? body.getItemType() : null,
                    body != null ? body.getAlias() : null
            );
            return ItemPriceResBody.success(prices);
        } catch (Exception e) {
            return ItemPriceResBody.error("查询失败: " + e.getMessage());
        }
    }

    @PostMapping("/hospital/info")
    public HospitalInfoResBody getHospitalInfo() {
        try {
            String info = hospitalInfoService.getHospitalInfo();
            return HospitalInfoResBody.success(info);
        } catch (Exception e) {
            return HospitalInfoResBody.error("查询失败: " + e.getMessage());
        }
    }

    @PostMapping("/department/info")
    public DepartmentInfoResBody getDepartmentInfo(@RequestBody(required = false) DepartmentInfoReqBody body) {
        try {
            String deptCode = body != null ? body.getDepartmentCode() : null;
            String deptName = body != null ? body.getDepartmentName() : null;
            
            List<Department> departments = departmentRepository.search(deptCode, deptName);
            return DepartmentInfoResBody.success(departments);
        } catch (Exception e) {
            return DepartmentInfoResBody.error("查询失败: " + e.getMessage());
        }
    }

    @PostMapping("/doctor/info")
    public DoctorInfoResBody getDoctorInfo(@RequestBody(required = false) DoctorInfoReqBody body) {
        try {
            String doctorCode = body != null ? body.getDoctorCode() : null;
            String doctorName = body != null ? body.getDoctorName() : null;
            
            List<Doctor> doctors = doctorRepository.search(null, doctorCode, doctorName);
            return DoctorInfoResBody.success(doctors);
        } catch (Exception e) {
            return DoctorInfoResBody.error("查询失败: " + e.getMessage());
        }
    }
}
