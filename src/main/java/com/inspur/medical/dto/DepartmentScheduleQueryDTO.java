package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DepartmentScheduleQueryDTO {
    @JsonProperty("SearchDate")
    private String searchDate;
}
