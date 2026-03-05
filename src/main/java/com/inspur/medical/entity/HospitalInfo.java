package com.inspur.medical.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "hospital_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalInfo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Id")
    private Long id;
    
    @Column(name = "hospital_name", length = 200)
    @JsonProperty("HospitalName")
    private String hospitalName;
    
    @Column(name = "hospital_code", length = 50)
    @JsonProperty("HospitalCode")
    private String hospitalCode;
    
    @Column(name = "hospital_level", length = 50)
    @JsonProperty("HospitalLevel")
    private String hospitalLevel;
    
    @Column(name = "hospital_type", length = 50)
    @JsonProperty("HospitalType")
    private String hospitalType;
    
    @Column(name = "address", length = 500)
    @JsonProperty("Address")
    private String address;
    
    @Column(name = "phone", length = 50)
    @JsonProperty("Phone")
    private String phone;
    
    @Column(name = "website", length = 200)
    @JsonProperty("Website")
    private String website;
    
    @Column(name = "introduction", length = 2000)
    @JsonProperty("Introduction")
    private String introduction;
    
    @Column(name = "business_hours", length = 200)
    @JsonProperty("BusinessHours")
    private String businessHours;
}
