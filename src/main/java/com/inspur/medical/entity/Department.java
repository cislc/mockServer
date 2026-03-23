package com.inspur.medical.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "department")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Id")
    private Long id;
    
    @Column(name = "department_code", unique = true, nullable = false, length = 50)
    @JsonProperty("DepartmentCode")
    private String departmentCode;
    
    @Column(name = "department_name", nullable = false, length = 100)
    @JsonProperty("DepartmentName")
    private String departmentName;
    
    @Column(name = "department_des", length = 1000)
    @JsonProperty("DepartmentDes")
    private String departmentDes;
    
    @Column(name = "department_image", length = 500)
    @JsonProperty("DepartmentImage")
    private String departmentImage;
}
