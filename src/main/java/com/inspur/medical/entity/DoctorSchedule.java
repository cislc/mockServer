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
    
    @Column(name = "clinic_room_code", length = 50)
    @JsonProperty("ClinicRoomCode")
    private String clinicRoomCode;
    
    @Column(name = "doctor_code", length = 50)
    @JsonProperty("DoctorCode")
    private String doctorCode;
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_code", referencedColumnName = "department_code", insertable = false, updatable = false)
    private Department department;
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_code", referencedColumnName = "doctor_code", insertable = false, updatable = false)
    private Doctor doctor;
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinic_room_code", referencedColumnName = "room_code", insertable = false, updatable = false)
    private ClinicRoom clinicRoom;

    @JsonProperty("DepartmentName")
    public String getDepartmentName() {
        return department != null ? department.getDepartmentName() : null;
    }

    @JsonProperty("ClinicRoomName")
    public String getClinicRoomName() {
        return clinicRoom != null ? clinicRoom.getRoomName() : null;
    }

    @JsonProperty("DoctorName")
    public String getDoctorName() {
        return doctor != null ? doctor.getDoctorName() : null;
    }

    @JsonProperty("DoctorTitleCode")
    public String getDoctorTitleCode() {
        return doctor != null ? doctor.getDoctorTitleCode() : null;
    }

    @JsonProperty("DoctorTitle")
    public String getDoctorTitle() {
        return doctor != null ? doctor.getTitle() : null;
    }

    @JsonProperty("DoctorSpec")
    public String getDoctorSpec() {
        return doctor != null ? doctor.getSpecialty() : null;
    }
    
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
    
    @Column(name = "available_number_str", length = 500)
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
