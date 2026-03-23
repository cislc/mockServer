package com.inspur.medical.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DoctorInfoReqBody {
    @JsonProperty("DoctorCode")
    private String doctorCode;
    @JsonProperty("DoctorName")
    private String doctorName;
}
