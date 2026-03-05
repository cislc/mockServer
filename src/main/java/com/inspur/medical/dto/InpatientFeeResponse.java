package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InpatientFeeResponse {
    
    @JsonProperty("ResultCode")
    private String resultCode;
    
    @JsonProperty("ResultContent")
    private String resultContent;
    
    @JsonProperty("RecordCount")
    private String recordCount;
    
    @JsonProperty("RecordList")
    private List<InpatientFeeRecordDTO> recordList;
    
    public static InpatientFeeResponse success(List<InpatientFeeRecordDTO> recordList) {
        return new InpatientFeeResponse("1", "查询成功", String.valueOf(recordList.size()), recordList);
    }
    
    public static InpatientFeeResponse error(String message) {
        return new InpatientFeeResponse("0", message, "0", null);
    }
}
