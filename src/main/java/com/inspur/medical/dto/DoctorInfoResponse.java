package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inspur.medical.entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorInfoResponse {
    
    @JsonProperty("ResultCode")
    private String resultCode;
    
    @JsonProperty("ResultContent")
    private String resultContent;
    
    @JsonProperty("Doctors")
    private List<Doctor> doctors;
    
    public static DoctorInfoResponse success(List<Doctor> doctors) {
        return new DoctorInfoResponse("1", "查询成功", doctors);
    }
    
    public static DoctorInfoResponse error(String message) {
        return new DoctorInfoResponse("0", message, null);
    }
}
