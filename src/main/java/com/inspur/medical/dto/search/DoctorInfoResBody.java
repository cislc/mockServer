package com.inspur.medical.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inspur.medical.entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorInfoResBody {
    @JsonProperty("ResultCode")
    private Integer resultCode;
    
    @JsonProperty("ResultContent")
    private String resultContent;
    
    @JsonProperty("Doctors")
    private List<Doctor> doctors;
    
    public static DoctorInfoResBody success(List<Doctor> doctors) {
        return new DoctorInfoResBody(0, "成功", doctors);
    }
    
    public static DoctorInfoResBody error(String message) {
        return new DoctorInfoResBody(1, message, null);
    }
}
