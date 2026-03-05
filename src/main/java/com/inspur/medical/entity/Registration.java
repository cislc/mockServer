package com.inspur.medical.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "registration")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Registration {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Id")
    private Long id;
    
    @Column(name = "patient_id", length = 50)
    @JsonProperty("PatientID")
    private String patientID;
    
    @Column(name = "schedule_item_code", length = 50)
    @JsonProperty("ScheduleItemCode")
    private String scheduleItemCode;
    
    @Column(name = "lock_queue_no", length = 50)
    @JsonProperty("LockQueueNo")
    private String lockQueueNo;
    
    @Column(name = "card_no", length = 50)
    @JsonProperty("CardNo")
    private String cardNo;
    
    @Column(name = "transaction_id", length = 100)
    @JsonProperty("TransactionId")
    private String transactionId;
    
    @Column(name = "adm_doc", length = 50)
    @JsonProperty("AdmDoc")
    private String admDoc;
    
    @Column(name = "adm_date", length = 20)
    @JsonProperty("AdmDate")
    private String admDate;
    
    @Column(name = "adm_time", length = 20)
    @JsonProperty("AdmTime")
    private String admTime;
    
    @Column(name = "reg_fee", length = 20)
    @JsonProperty("RegFee")
    private String regFee;
    
    @Column(name = "status", length = 10)
    @JsonProperty("Status")
    private String status;
}
