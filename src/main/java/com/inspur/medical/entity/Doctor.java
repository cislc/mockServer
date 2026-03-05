package com.inspur.medical.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "doctor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Id")
    private Long id;
    
    @Column(name = "doctor_code", unique = true, nullable = false, length = 50)
    @JsonProperty("DoctorCode")
    private String doctorCode;
    
    @Column(name = "doctor_name", nullable = false, length = 100)
    @JsonProperty("DoctorName")
    private String doctorName;
    
    @Column(name = "department_code", nullable = false, length = 50)
    @JsonProperty("DepartmentCode")
    private String departmentCode;
    
    @Column(name = "title", length = 50)
    @JsonProperty("Title")
    private String title;
    
    @Column(name = "specialty", length = 200)
    @JsonProperty("Specialty")
    private String specialty;
    
    @Column(name = "doctor_des", length = 1000)
    @JsonProperty("DoctorDes")
    private String doctorDes;
    
    @Column(name = "doctor_image", length = 500)
    @JsonProperty("DoctorImage")
    private String doctorImage;
}
