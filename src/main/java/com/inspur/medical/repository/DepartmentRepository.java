package com.inspur.medical.repository;

import com.inspur.medical.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByDepartmentCode(String departmentCode);

    @org.springframework.data.jpa.repository.Query("SELECT d FROM Department d WHERE " +
           "(:departmentCode IS NULL OR :departmentCode = '' OR d.departmentCode = :departmentCode) AND " +
           "(:departmentName IS NULL OR :departmentName = '' OR d.departmentName LIKE CONCAT('%', :departmentName, '%'))")
    java.util.List<Department> search(@org.springframework.data.repository.query.Param("departmentCode") String departmentCode, 
                                      @org.springframework.data.repository.query.Param("departmentName") String departmentName);
}
