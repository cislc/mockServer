package com.inspur.medical.service;

import com.inspur.medical.dto.ScheduleQueryDTO;
import com.inspur.medical.entity.Department;
import com.inspur.medical.entity.Doctor;
import com.inspur.medical.entity.DoctorSchedule;
import com.inspur.medical.repository.DepartmentRepository;
import com.inspur.medical.repository.DoctorRepository;
import com.inspur.medical.repository.DepartmentRepository;
import com.inspur.medical.repository.DoctorRepository;
import com.inspur.medical.repository.DoctorScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorScheduleService {

    @Autowired
    private DoctorScheduleRepository scheduleRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DepartmentRepository departmentRepository;


    public List<DoctorSchedule> querySchedules(ScheduleQueryDTO queryDTO) {
        List<DoctorSchedule> result;
        boolean hasDateRange = queryDTO.getStartDate() != null && !queryDTO.getStartDate().isEmpty() &&
                               queryDTO.getEndDate() != null && !queryDTO.getEndDate().isEmpty();

        if (queryDTO.getDoctorCode() != null && !queryDTO.getDoctorCode().isEmpty()) {
            if (hasDateRange) {
                result = scheduleRepository.findByDoctorCodeAndDateRange(queryDTO.getDoctorCode(), queryDTO.getStartDate(), queryDTO.getEndDate());
            } else {
                result = scheduleRepository.findByDoctorCode(queryDTO.getDoctorCode());
            }
        } else if (queryDTO.getDepartmentCode() != null && !queryDTO.getDepartmentCode().isEmpty()) {
            if (hasDateRange) {
                result = scheduleRepository.findByDepartmentCodeAndDateRange(queryDTO.getDepartmentCode(), queryDTO.getStartDate(), queryDTO.getEndDate());
            } else {
                result = scheduleRepository.findByDepartmentCode(queryDTO.getDepartmentCode());
            }
        } else {
            if (hasDateRange) {
                result = scheduleRepository.findByDateRange(queryDTO.getStartDate(), queryDTO.getEndDate());
            } else {
                result = scheduleRepository.findAll();
            }
        }

        String today = java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return result.stream()
                .filter(s -> s.getServiceDate() != null && s.getServiceDate().compareTo(today) >= 0)
                .collect(java.util.stream.Collectors.toList());
    }



    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public List<Doctor> getDoctorsByDepartment(String departmentCode) {
        return doctorRepository.findByDepartmentCode(departmentCode);
    }
}
