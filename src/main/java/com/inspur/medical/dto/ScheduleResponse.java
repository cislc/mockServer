package com.inspur.medical.dto;

import com.inspur.medical.entity.DoctorSchedule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleResponse {
    private String ResultCode;
    private String ResultContent;
    private String RecordCount;
    private List<DoctorSchedule> Schedules;

    public static ScheduleResponse success(List<DoctorSchedule> schedules) {
        ScheduleResponse response = new ScheduleResponse();
        response.setResultCode("1");
        response.setResultContent("查询成功");
        response.setRecordCount(String.valueOf(schedules.size()));
        response.setSchedules(schedules);
        return response;
    }

    public static ScheduleResponse error(String message) {
        ScheduleResponse response = new ScheduleResponse();
        response.setResultCode("0");
        response.setResultContent(message);
        response.setRecordCount("0");
        return response;
    }
}
