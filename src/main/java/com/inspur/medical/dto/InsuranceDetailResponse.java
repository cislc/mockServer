package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class InsuranceDetailResponse {
    @JsonProperty("ResultCode")
    private String resultCode;
    
    @JsonProperty("ResultContent")
    private String resultContent;
    
    @JsonProperty("feetype")
    private String feetype;
    
    @JsonProperty("totalprice")
    private String totalprice;
    
    @JsonProperty("chargedate")
    private String chargedate;
    
    @JsonProperty("chargetime")
    private String chargetime;
    
    @JsonProperty("rgstflow")
    private String rgstflow;
    
    @JsonProperty("rgstfee")
    private String rgstfee;
    
    @JsonProperty("rgstdname")
    private String rgstdname;
    
    @JsonProperty("maindisecode")
    private String maindisecode;
    
    @JsonProperty("maindisename")
    private String maindisename;
    
    @JsonProperty("initrxord")
    private String initrxord;
    
    @JsonProperty("begntime")
    private String begntime;
    
    @JsonProperty("idno")
    private String idno;
    
    @JsonProperty("username")
    private String username;
    
    @JsonProperty("idtype")
    private String idtype;
    
    @JsonProperty("iptotpno")
    private String iptotpno;
    
    @JsonProperty("deptname")
    private String deptname;
    
    @JsonProperty("caty")
    private String caty;
    
    @JsonProperty("acctusedflag")
    private String acctusedflag;
    
    @JsonProperty("mdtrtcerttype")
    private String mdtrtcerttype;
    
    @JsonProperty("diseasecode1")
    private String diseasecode1;
    
    @JsonProperty("diseasecode2")
    private String diseasecode2;
    
    @JsonProperty("diseasecode3")
    private String diseasecode3;
    
    @JsonProperty("spdiscod1")
    private String spdiscod1;
    
    @JsonProperty("deptcode")
    private String deptcode;
    
    @JsonProperty("doccode")
    private String doccode;
    
    @JsonProperty("docname")
    private String docname;
    
    @JsonProperty("pracpsncode")
    private String pracpsncode;
    
    @JsonProperty("detailssize")
    private String detailssize;
    
    @JsonProperty("mipaytype")
    private String mipaytype;
    
    @JsonProperty("aka130")
    private String aka130;
    
    @JsonProperty("mdtrtseq")
    private String mdtrtseq;
    
    @JsonProperty("optername")
    private String optername;
    
    @JsonProperty("mdtrt_id")
    private String mdtrtId;
    
    @JsonProperty("bChronicDisease")
    private String bChronicDisease;
    
    @JsonProperty("diseCodg")
    private String diseCodg;
    
    @JsonProperty("diseName")
    private String diseName;
    
    @JsonProperty("endtime")
    private String endtime;
    
    @JsonProperty("detail")
    private List<InsuranceDetailDTO> detail;
    
    @JsonProperty("diseinfolist")
    private List<InsuranceDiseInfoDTO> diseinfolist;
    
    public static InsuranceDetailResponse success(InsuranceDetailResponse response) {
        response.setResultCode("1");
        response.setResultContent("查询成功");
        return response;
    }
    
    public static InsuranceDetailResponse error(String message) {
        InsuranceDetailResponse response = new InsuranceDetailResponse();
        response.setResultCode("0");
        response.setResultContent(message);
        return response;
    }
}
