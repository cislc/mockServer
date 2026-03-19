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
        boolean hasDateRange = queryDTO.getStartDate() != null && !queryDTO.getStartDate().isEmpty() &&
                               queryDTO.getEndDate() != null && !queryDTO.getEndDate().isEmpty();

        if (queryDTO.getDoctorCode() != null && !queryDTO.getDoctorCode().isEmpty()) {
            if (hasDateRange) {
                return scheduleRepository.findByDoctorCodeAndDateRange(queryDTO.getDoctorCode(), queryDTO.getStartDate(), queryDTO.getEndDate());
            }
            return scheduleRepository.findByDoctorCode(queryDTO.getDoctorCode());
        } else if (queryDTO.getDepartmentCode() != null && !queryDTO.getDepartmentCode().isEmpty()) {
            if (hasDateRange) {
                return scheduleRepository.findByDepartmentCodeAndDateRange(queryDTO.getDepartmentCode(), queryDTO.getStartDate(), queryDTO.getEndDate());
            }
            return scheduleRepository.findByDepartmentCode(queryDTO.getDepartmentCode());
        } else {
            if (hasDateRange) {
                return scheduleRepository.findByDateRange(queryDTO.getStartDate(), queryDTO.getEndDate());
            }
            return scheduleRepository.findAll();
        }
    }



    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public List<Doctor> getDoctorsByDepartment(String departmentCode) {
        return doctorRepository.findByDepartmentCode(departmentCode);
    }
}
