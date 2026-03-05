package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceDetailDTO {
    @JsonProperty("feedetl_sn")
    private String feedetlSn;
    
    @JsonProperty("mdtrt_id")
    private String mdtrtId;
    
    @JsonProperty("psn_no")
    private String psnNo;
    
    @JsonProperty("chrg_bchno")
    private String chrgBchno;
    
    @JsonProperty("dise_code")
    private String diseCode;
    
    @JsonProperty("rxno")
    private String rxno;
    
    @JsonProperty("rx_circ_flag")
    private String rxCircFlag;
    
    @JsonProperty("fee_ocur_time")
    private String feeOcurTime;
    
    @JsonProperty("med_list_codg")
    private String medListCodg;
    
    @JsonProperty("medins_list_codg")
    private String medinsListCodg;
    
    @JsonProperty("det_item_fee_sumamt")
    private String detItemFeeSumamt;
    
    @JsonProperty("cnt")
    private String cnt;
    
    @JsonProperty("pric")
    private String pric;
    
    @JsonProperty("sin_dos_dscr")
    private String sinDosDscr;
    
    @JsonProperty("used_frqu_dscr")
    private String usedFrquDscr;
    
    @JsonProperty("prd_days")
    private String prdDays;
    
    @JsonProperty("medc_way_dscr")
    private String medcWayDscr;
    
    @JsonProperty("bilg_dept_codg")
    private String bilgDeptCodg;
    
    @JsonProperty("bilg_dept_name")
    private String bilgDeptName;
    
    @JsonProperty("bilg_dr_codg")
    private String bilgDrCodg;
    
    @JsonProperty("bilg_dr_name")
    private String bilgDrName;
    
    @JsonProperty("acord_dept_codg")
    private String acordDeptCodg;
    
    @JsonProperty("acord_dept_name")
    private String acordDeptName;
    
    @JsonProperty("orders_dr_code")
    private String ordersDrCode;
    
    @JsonProperty("orders_dr_name")
    private String ordersDrName;
    
    @JsonProperty("hosp_appr_flag")
    private String hospApprFlag;
    
    @JsonProperty("tcmdrug_used_way")
    private String tcmdrugUsedWay;
    
    @JsonProperty("etip_flag")
    private String etipFlag;
    
    @JsonProperty("etip_hosp_code")
    private String etipHospCode;
    
    @JsonProperty("dscg_tkdrug_flag")
    private String dscgTkdrugFlag;
    
    @JsonProperty("matn_fee_flag")
    private String matnFeeFlag;
    
    @JsonProperty("comb_no")
    private String combNo;
}
