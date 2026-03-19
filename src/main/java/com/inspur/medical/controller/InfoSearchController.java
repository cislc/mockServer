package com.inspur.medical.controller;

import com.inspur.medical.dto.common.ApiRequest;
import com.inspur.medical.dto.common.ApiResponse;
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
    public ApiResponse<ItemPriceResBody> searchItemPrice(@RequestBody ApiRequest<ItemPriceReqBody> request) {
        try {
            ItemPriceReqBody body = request.getBody();
            List<ItemPrice> prices = itemPriceService.searchItemPrice(
                    body != null ? body.getItemType() : null,
                    body != null ? body.getAlias() : null
            );
            return ApiResponse.success(ItemPriceResBody.success(prices));
        } catch (Exception e) {
            return ApiResponse.success(ItemPriceResBody.error("查询失败: " + e.getMessage()));
        }
    }

    @PostMapping("/hospital/info")
    public ApiResponse<HospitalInfoResBody> getHospitalInfo() {
        try {
            String info = hospitalInfoService.getHospitalInfo();
            return ApiResponse.success(HospitalInfoResBody.success(info));
        } catch (Exception e) {
            return ApiResponse.success(HospitalInfoResBody.error("查询失败: " + e.getMessage()));
        }
    }

    @PostMapping("/department/info")
    public ApiResponse<DepartmentInfoResBody> getDepartmentInfo() {
        try {
            List<Department> departments = departmentRepository.findAll();
            return ApiResponse.success(DepartmentInfoResBody.success(departments));
        } catch (Exception e) {
            return ApiResponse.success(DepartmentInfoResBody.error("查询失败: " + e.getMessage()));
        }
    }

    @PostMapping("/doctor/info")
    public ApiResponse<DoctorInfoResBody> getDoctorInfo(@RequestBody ApiRequest<DoctorInfoReqBody> request) {
        try {
            List<Doctor> doctors;
            DoctorInfoReqBody body = request.getBody();
            String deptCode = body != null ? body.getDepartmentCode() : null;
            
            if (deptCode != null && !deptCode.trim().isEmpty()) {
                doctors = doctorRepository.findByDepartmentCode(deptCode);
            } else {
                doctors = doctorRepository.findAll();
            }
            return ApiResponse.success(DoctorInfoResBody.success(doctors));
        } catch (Exception e) {
            return ApiResponse.success(DoctorInfoResBody.error("查询失败: " + e.getMessage()));
        }
    }
}
