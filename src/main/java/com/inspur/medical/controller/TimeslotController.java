package com.inspur.medical.controller;

import com.inspur.medical.dto.TimeslotDTO;
import com.inspur.medical.dto.TimeslotQueryDTO;
import com.inspur.medical.dto.TimeslotResponse;
import com.inspur.medical.entity.DoctorSchedule;
import com.inspur.medical.repository.DoctorScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/search")
public class TimeslotController {

    @Autowired
    private DoctorScheduleRepository scheduleRepository;

    @PostMapping("/timeslot")
    public TimeslotResponse getTimeslot(@RequestBody TimeslotQueryDTO queryDTO) {
        try {
            List<DoctorSchedule> schedules;
            
            boolean hasDocCode = queryDTO.getDoctorCode() != null && !queryDTO.getDoctorCode().trim().isEmpty();
            boolean hasDocName = queryDTO.getDoctorName() != null && !queryDTO.getDoctorName().trim().isEmpty();
            
            if (hasDocCode && hasDocName) {
                return TimeslotResponse.error("无法查询：DoctorCode 和 DoctorName 不允许同时传值");
            }
            if (!hasDocCode && !hasDocName) {
                return TimeslotResponse.error("无法查询：DoctorCode 和 DoctorName 不允许同时为空，请传入其中之一");
            }
            
            if (hasDocCode) {
                schedules = scheduleRepository.findByDoctorCode(queryDTO.getDoctorCode());
            } else {
                schedules = scheduleRepository.findByDoctorName(queryDTO.getDoctorName());
            }
            
            List<TimeslotDTO> timeRanges = new ArrayList<>();
            for (DoctorSchedule schedule : schedules) {
                TimeslotDTO dto = new TimeslotDTO();
                dto.setServiceDate(schedule.getServiceDate());
                dto.setWeekDay(schedule.getWeekDay());
                dto.setSessionCode(schedule.getSessionCode());
                dto.setSessionName(schedule.getSessionName());
                dto.setAvailableNumStr(schedule.getAvailableNumberStr());
                dto.setStartTime(schedule.getStartTime());
                dto.setEndTime(schedule.getEndTime());
                dto.setAvailableTotalNum(schedule.getAvailableTotalNum());
                dto.setAvailableLeftNum(schedule.getAvailableLeftNum());
                timeRanges.add(dto);
            }
            
            return TimeslotResponse.success(timeRanges);
        } catch (Exception e) {
            return TimeslotResponse.error("查询失败: " + e.getMessage());
        }
    }
}
