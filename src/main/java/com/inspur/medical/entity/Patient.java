package com.inspur.medical.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "patient")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Id")
    private Long id;
    
    @Column(name = "patient_id", unique = true, length = 50)
    @JsonProperty("PatientID")
    private String patientID;
    
    @Column(name = "patient_name", length = 100)
    @JsonProperty("PatientName")
    private String patientName;
    
    @Column(name = "sex_code", length = 10)
    @JsonProperty("SexCode")
    private String sexCode;
    
    @Column(name = "sex", length = 10)
    @JsonProperty("Sex")
    private String sex;
    
    @Column(name = "dob", length = 20)
    @JsonProperty("DOB")
    private String dob;
    
    @Column(name = "document_id", length = 50)
    @JsonProperty("DocumentID")
    private String documentID;
    
    @Column(name = "address", length = 200)
    @JsonProperty("Address")
    private String address;
    
    @Column(name = "id_type_code", length = 10)
    @JsonProperty("IDTypeCode")
    private String idTypeCode;
    
    @Column(name = "id_type", length = 50)
    @JsonProperty("IDType")
    private String idType;
    
    @Column(name = "id_no", length = 50)
    @JsonProperty("IDNo")
    private String idNo;
    
    @Column(name = "yb_flag", length = 10)
    @JsonProperty("YBFlag")
    private String ybFlag;
    
    @Column(name = "pat_type", length = 50)
    @JsonProperty("PatType")
    private String patType;
    
    @Column(name = "pat_type_code", length = 10)
    @JsonProperty("PatTypeCode")
    private String patTypeCode;
    
    @Column(name = "mobile", length = 20)
    @JsonProperty("Mobile")
    private String mobile;
    
    @Column(name = "insure_card_no", length = 50)
    @JsonProperty("InsureCardNo")
    private String insureCardNo;
    
    @Column(name = "acc_info", length = 100)
    @JsonProperty("AccInfo")
    private String accInfo;
    
    @Column(name = "acc_info_balance", length = 20)
    @JsonProperty("AccInfoBalance")
    private String accInfoBalance;
    
    @Column(name = "acc_info_no", length = 50)
    @JsonProperty("AccInfoNo")
    private String accInfoNo;
    
    @Column(name = "patient_card", length = 50)
    @JsonProperty("PatientCard")
    private String patientCard;
}
