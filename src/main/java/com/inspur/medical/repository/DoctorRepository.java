package com.inspur.medical.repository;

import com.inspur.medical.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByDoctorCode(String doctorCode);
    List<Doctor> findByDepartmentCode(String departmentCode);

    @org.springframework.data.jpa.repository.Query("SELECT d FROM Doctor d WHERE " +
           "(:departmentCode IS NULL OR :departmentCode = '' OR d.departmentCode = :departmentCode) AND " +
           "(:doctorCode IS NULL OR :doctorCode = '' OR d.doctorCode = :doctorCode) AND " +
           "(:doctorName IS NULL OR :doctorName = '' OR d.doctorName LIKE CONCAT('%', :doctorName, '%'))")
    List<Doctor> search(@org.springframework.data.repository.query.Param("departmentCode") String departmentCode, 
                        @org.springframework.data.repository.query.Param("doctorCode") String doctorCode, 
                        @org.springframework.data.repository.query.Param("doctorName") String doctorName);
}
