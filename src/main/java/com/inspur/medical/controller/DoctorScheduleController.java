package com.inspur.medical.controller;

import com.inspur.medical.dto.ApiResponse;
import com.inspur.medical.dto.ScheduleQueryDTO;
import com.inspur.medical.dto.ScheduleResponse;
import com.inspur.medical.entity.Department;
import com.inspur.medical.entity.Doctor;
import com.inspur.medical.entity.DoctorSchedule;
import com.inspur.medical.service.DoctorScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class DoctorScheduleController {

    @Autowired
    private DoctorScheduleService scheduleService;

    @PostMapping("/department/schedule")
    public ScheduleResponse querySchedules(@RequestBody ScheduleQueryDTO queryDTO) {
        try {
            List<DoctorSchedule> schedules = scheduleService.querySchedules(queryDTO);
            return ScheduleResponse.success(schedules);
        } catch (Exception e) {
            return ScheduleResponse.error("查询失败: " + e.getMessage());
        }
    }

    @PostMapping("/generate/{departmentCode}")
    public ApiResponse<String> generateSchedules(
            @PathVariable String departmentCode,
            @RequestParam(defaultValue = "30") int days) {
        try {
            scheduleService.generateMockSchedules(departmentCode, days);
            return ApiResponse.success("排班数据生成成功");
        } catch (Exception e) {
            return ApiResponse.error("生成排班数据失败: " + e.getMessage());
        }
    }
}
