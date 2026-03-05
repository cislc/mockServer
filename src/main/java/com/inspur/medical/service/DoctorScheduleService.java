package com.inspur.medical.service;

import com.inspur.medical.dto.ScheduleQueryDTO;
import com.inspur.medical.entity.Department;
import com.inspur.medical.entity.Doctor;
import com.inspur.medical.entity.DoctorSchedule;
import com.inspur.medical.repository.DepartmentRepository;
import com.inspur.medical.repository.DoctorRepository;
import com.inspur.medical.repository.DoctorScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DoctorScheduleService {

    @Autowired
    private DoctorScheduleRepository scheduleRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    private static final Random random = new Random();
    private static int scheduleCounter = 1;

    public List<DoctorSchedule> querySchedules(ScheduleQueryDTO queryDTO) {
        if (queryDTO.getDoctorCode() != null && !queryDTO.getDoctorCode().isEmpty()) {
            return scheduleRepository.findByDoctorCode(queryDTO.getDoctorCode());
        } else if (queryDTO.getDepartmentCode() != null && !queryDTO.getDepartmentCode().isEmpty()) {
            return scheduleRepository.findByDepartmentCode(queryDTO.getDepartmentCode());
        } else {
            return scheduleRepository.findAll();
        }
    }

    @Transactional
    public void generateMockSchedules(String departmentCode, int days) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode)
                .orElseThrow(() -> new RuntimeException("Department not found: " + departmentCode));

        List<Doctor> doctors = doctorRepository.findByDepartmentCode(departmentCode);
        if (doctors.isEmpty()) {
            throw new RuntimeException("No doctors found for department: " + departmentCode);
        }

        LocalDate today = LocalDate.now();
        List<DoctorSchedule> schedules = new ArrayList<>();

        for (int i = 0; i < days; i++) {
            LocalDate scheduleDate = today.plusDays(i);
            DayOfWeek dayOfWeek = scheduleDate.getDayOfWeek();
            String weekDay = String.valueOf(dayOfWeek.getValue());
            
            for (Doctor doctor : doctors) {
                if (random.nextBoolean()) {
                    DoctorSchedule morningSchedule = createSchedule(
                            doctor, department, scheduleDate, weekDay, "AM", "上午", 
                            "08:00", "12:00");
                    schedules.add(morningSchedule);
                }

                if (random.nextBoolean()) {
                    DoctorSchedule afternoonSchedule = createSchedule(
                            doctor, department, scheduleDate, weekDay, "PM", "下午",
                            "14:00", "18:00");
                    schedules.add(afternoonSchedule);
                }
            }
        }

        scheduleRepository.saveAll(schedules);
    }

    private DoctorSchedule createSchedule(Doctor doctor, Department department, 
                                         LocalDate date, String weekDay, String sessionCode,
                                         String sessionName, String startTime, String endTime) {
        DoctorSchedule schedule = new DoctorSchedule();
        
        schedule.setMCode("SC" + String.format("%03d", scheduleCounter++));
        schedule.setServiceDate(date.toString());
        schedule.setWeekDay(weekDay);
        schedule.setSessionCode(sessionCode);
        schedule.setSessionName(sessionName);
        schedule.setStartTime(startTime);
        schedule.setEndTime(endTime);
        
        schedule.setDepartmentCode(department.getDepartmentCode());
        schedule.setDepartmentName(department.getDepartmentName());
        
        String roomNum = department.getDepartmentCode().replace("DEPT", "");
        schedule.setClinicRoomCode("CR" + roomNum + "01");
        schedule.setClinicRoomName(roomNum + "01诊室");
        
        schedule.setDoctorCode(doctor.getDoctorCode());
        schedule.setDoctorName(doctor.getDoctorName());
        schedule.setDoctorTitleCode("P01");
        schedule.setDoctorTitle(doctor.getTitle() != null ? doctor.getTitle() : "主任医师");
        schedule.setDoctorSpec(doctor.getSpecialty() != null ? doctor.getSpecialty() : "综合诊疗");
        
        schedule.setDoctorSessTypeCode("ST01");
        schedule.setDoctorSessType("专家门诊");
        
        schedule.setServiceCode("MED" + roomNum);
        schedule.setServiceName(department.getDepartmentName() + "专科");
        
        double baseFee = 50.0 + random.nextInt(20);
        schedule.setFee(String.format("%.2f", baseFee));
        schedule.setRegFee("15.00");
        schedule.setCheckupFee("25.00");
        schedule.setServiceFee("10.00");
        schedule.setOtherFee("0.00");
        
        int totalSlots = 15 + random.nextInt(16);
        int leftSlots = random.nextInt(totalSlots / 2 + 1);
        schedule.setAvailableTotalNum(String.valueOf(totalSlots));
        schedule.setAvailableLeftNum(String.valueOf(leftSlots));
        schedule.setAvailableNumberStr(sessionName + "余号" + leftSlots);
        
        schedule.setAdmitAddressString(department.getDepartmentName() + "门诊" + roomNum + "楼A区");
        schedule.setAdmitTimeRange(startTime + "-" + endTime.substring(0, 5));
        schedule.setNote("请携带既往病历及检查报告");
        
        schedule.setTimeRangeFlag("1");
        schedule.setScheduleStatus(leftSlots > 0 ? "1" : "0");
        
        return schedule;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public List<Doctor> getDoctorsByDepartment(String departmentCode) {
        return doctorRepository.findByDepartmentCode(departmentCode);
    }
}
