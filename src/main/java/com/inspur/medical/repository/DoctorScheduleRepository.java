package com.inspur.medical.repository;

import com.inspur.medical.entity.DoctorSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorScheduleRepository extends JpaRepository<DoctorSchedule, Long> {
    
    @Query("SELECT s FROM DoctorSchedule s WHERE s.departmentCode = :departmentCode")
    List<DoctorSchedule> findByDepartmentCode(@Param("departmentCode") String departmentCode);
    
    @Query("SELECT s FROM DoctorSchedule s WHERE s.doctorCode = :doctorCode")
    List<DoctorSchedule> findByDoctorCode(@Param("doctorCode") String doctorCode);
    
    @Query("SELECT COUNT(s) FROM DoctorSchedule s WHERE s.departmentCode = :departmentCode")
    long countByDepartmentCode(@Param("departmentCode") String departmentCode);
    
    @Query("SELECT s FROM DoctorSchedule s WHERE s.departmentCode = :departmentCode AND s.serviceDate >= :startDate AND s.serviceDate <= :endDate")
    List<DoctorSchedule> findByDepartmentCodeAndDateRange(
            @Param("departmentCode") String departmentCode, 
            @Param("startDate") String startDate, 
            @Param("endDate") String endDate);
            
    @Query("SELECT s FROM DoctorSchedule s WHERE s.doctorCode = :doctorCode AND s.serviceDate >= :startDate AND s.serviceDate <= :endDate")
    List<DoctorSchedule> findByDoctorCodeAndDateRange(
            @Param("doctorCode") String doctorCode, 
            @Param("startDate") String startDate, 
            @Param("endDate") String endDate);
            
    @Query("SELECT s FROM DoctorSchedule s WHERE s.serviceDate >= :startDate AND s.serviceDate <= :endDate")
    List<DoctorSchedule> findByDateRange(
            @Param("startDate") String startDate, 
            @Param("endDate") String endDate);
}
