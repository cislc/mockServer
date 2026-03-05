package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaidRecordResponse {
    
    @JsonProperty("ResultCode")
    private String resultCode;
    
    @JsonProperty("ResultContent")
    private String resultContent;
    
    @JsonProperty("RecordCount")
    private String recordCount;
    
    @JsonProperty("RecordList")
    private List<PaidRecordDTO> recordList;
    
    public static PaidRecordResponse success(List<PaidRecordDTO> recordList) {
        return new PaidRecordResponse("1", "查询成功", String.valueOf(recordList.size()), recordList);
    }
    
    public static PaidRecordResponse error(String message) {
        return new PaidRecordResponse("0", message, "0", null);
    }
}
