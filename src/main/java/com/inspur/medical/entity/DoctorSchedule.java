package com.inspur.medical.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "doctor_schedule")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorSchedule {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Id")
    private Long id;
    
    @Column(name = "m_code", length = 50)
    @JsonProperty("MCode")
    private String mCode;
    
    @Column(name = "service_date", length = 20)
    @JsonProperty("ServiceDate")
    private String serviceDate;
    
    @Column(name = "week_day", length = 10)
    @JsonProperty("WeekDay")
    private String weekDay;
    
    @Column(name = "session_code", length = 20)
    @JsonProperty("SessionCode")
    private String sessionCode;
    
    @Column(name = "session_name", length = 50)
    @JsonProperty("SessionName")
    private String sessionName;
    
    @Column(name = "start_time", length = 20)
    @JsonProperty("StartTime")
    private String startTime;
    
    @Column(name = "end_time", length = 20)
    @JsonProperty("EndTime")
    private String endTime;
    
    @Column(name = "department_code", length = 50)
    @JsonProperty("DepartmentCode")
    private String departmentCode;
    
    @Column(name = "department_name", length = 100)
    @JsonProperty("DepartmentName")
    private String departmentName;
    
    @Column(name = "clinic_room_code", length = 50)
    @JsonProperty("ClinicRoomCode")
    private String clinicRoomCode;
    
    @Column(name = "clinic_room_name", length = 100)
    @JsonProperty("ClinicRoomName")
    private String clinicRoomName;
    
    @Column(name = "doctor_code", length = 50)
    @JsonProperty("DoctorCode")
    private String doctorCode;
    
    @Column(name = "doctor_name", length = 100)
    @JsonProperty("DoctorName")
    private String doctorName;
    
    @Column(name = "doctor_title_code", length = 20)
    @JsonProperty("DoctorTitleCode")
    private String doctorTitleCode;
    
    @Column(name = "doctor_title", length = 50)
    @JsonProperty("DoctorTitle")
    private String doctorTitle;
    
    @Column(name = "doctor_spec", length = 500)
    @JsonProperty("DoctorSpec")
    private String doctorSpec;
    
    @Column(name = "doctor_sess_type_code", length = 20)
    @JsonProperty("DoctorSessTypeCode")
    private String doctorSessTypeCode;
    
    @Column(name = "doctor_sess_type", length = 50)
    @JsonProperty("DoctorSessType")
    private String doctorSessType;
    
    @Column(name = "service_code", length = 50)
    @JsonProperty("ServiceCode")
    private String serviceCode;
    
    @Column(name = "service_name", length = 100)
    @JsonProperty("ServiceName")
    private String serviceName;
    
    @Column(name = "fee", length = 20)
    @JsonProperty("Fee")
    private String fee;
    
    @Column(name = "reg_fee", length = 20)
    @JsonProperty("RegFee")
    private String regFee;
    
    @Column(name = "checkup_fee", length = 20)
    @JsonProperty("CheckupFee")
    private String checkupFee;
    
    @Column(name = "service_fee", length = 20)
    @JsonProperty("ServiceFee")
    private String serviceFee;
    
    @Column(name = "other_fee", length = 20)
    @JsonProperty("OtherFee")
    private String otherFee;
    
    @Column(name = "available_number_str", length = 100)
    @JsonProperty("AvailableNumberStr")
    private String availableNumberStr;
    
    @Column(name = "admit_address_string", length = 200)
    @JsonProperty("AdmitAddressString")
    private String admitAddressString;
    
    @Column(name = "admit_time_range", length = 50)
    @JsonProperty("AdmitTimeRange")
    private String admitTimeRange;
    
    @Column(name = "note", length = 500)
    @JsonProperty("Note")
    private String note;
    
    @Column(name = "time_range_flag", length = 10)
    @JsonProperty("TimeRangeFlag")
    private String timeRangeFlag;
    
    @Column(name = "schedule_status", length = 10)
    @JsonProperty("ScheduleStatus")
    private String scheduleStatus;
    
    @Column(name = "available_total_num", length = 10)
    @JsonProperty("AvailableTotalNum")
    private String availableTotalNum;
    
    @Column(name = "available_left_num", length = 10)
    @JsonProperty("AvailableLeftNum")
    private String availableLeftNum;
}
