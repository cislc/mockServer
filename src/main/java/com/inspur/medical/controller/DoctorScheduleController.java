package com.inspur.medical.controller;

import com.inspur.medical.dto.ScheduleQueryDTO;
import com.inspur.medical.dto.ScheduleResponse;
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

    @PostMapping("/doctor/schedule")
    public ScheduleResponse queryDoctorSchedules(@RequestBody ScheduleQueryDTO queryDTO) {
        try {
            List<DoctorSchedule> schedules = scheduleService.querySchedules(queryDTO);
            return ScheduleResponse.success(schedules);
        } catch (Exception e) {
            return ScheduleResponse.error("查询失败: " + e.getMessage());
        }
    }
}
