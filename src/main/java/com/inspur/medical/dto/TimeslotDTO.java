package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeslotDTO {
    
    @JsonProperty("ServiceDate")
    private String serviceDate;
    
    @JsonProperty("WeekDay")
    private String weekDay;
    
    @JsonProperty("SessionCode")
    private String sessionCode;
    
    @JsonProperty("SessionName")
    private String sessionName;
    
    @JsonProperty("AvailableNumStr")
    private String availableNumStr;
    
    @JsonProperty("StartTime")
    private String startTime;
    
    @JsonProperty("EndTime")
    private String endTime;
    
    @JsonProperty("AvailableTotalNum")
    private String availableTotalNum;
    
    @JsonProperty("AvailableLeftNum")
    private String availableLeftNum;
}
