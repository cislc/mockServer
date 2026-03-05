package com.inspur.medical.controller;

import com.inspur.medical.dto.InsuranceDetailDTO;
import com.inspur.medical.dto.InsuranceDetailQueryDTO;
import com.inspur.medical.dto.InsuranceDetailResponse;
import com.inspur.medical.dto.InsuranceDiseInfoDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ssm/insurance")
public class InsuranceController {

    @PostMapping("/detail")
    public InsuranceDetailResponse getInsuranceDetail(@RequestBody InsuranceDetailQueryDTO queryDTO) {
        try {
            InsuranceDetailResponse response = new InsuranceDetailResponse();
            response.setFeetype("01");
            response.setTotalprice("150.00");
            response.setChargedate("2024-01-15");
            response.setChargetime("10:30:00");
            response.setRgstflow("RGST001");
            response.setRgstfee("15.00");
            response.setRgstdname("挂号科室");
            response.setMaindisecode("J00.001");
            response.setMaindisename("急性上呼吸道感染");
            response.setInitrxord("RX001");
            response.setBegntime("2024-01-15 10:30:00");
            response.setIdno("330106199001011234");
            response.setUsername("张三");
            response.setIdtype("01");
            response.setIptotpno("IP001");
            response.setDeptname("内科");
            response.setCaty("11");
            response.setAcctusedflag("1");
            response.setMdtrtcerttype("00");
            response.setDiseasecode1("J00.001");
            response.setDiseasecode2("");
            response.setDiseasecode3("");
            response.setSpdiscod1("SP001");
            response.setDeptcode("DEPT001");
            response.setDoccode("DOC001");
            response.setDocname("张医生");
            response.setPracpsncode("PRAC001");
            response.setDetailssize("2");
            response.setMipaytype("140100");
            response.setAka130("11");
            response.setMdtrtseq("SEQ001");
            response.setOptername("操作员");
            response.setMdtrtId("MDTRT001");
            response.setBChronicDisease("0");
            response.setDiseCodg("J00.001");
            response.setDiseName("急性上呼吸道感染");
            response.setEndtime("2024-01-15 11:00:00");
            
            List<InsuranceDetailDTO> details = new ArrayList<>();
            InsuranceDetailDTO detail1 = new InsuranceDetailDTO("FEED001", "MDTRT001", "PSN001", "BCH001",
                    "J00.001", "RX001", "1", "2024-01-15 10:30:00", "MED001", "MEDINS001",
                    "50.00", "1", "50.00", "口服", "每日三次", "3", "口服",
                    "DEPT001", "内科", "DOC001", "张医生", "DEPT001", "内科",
                    "DOC001", "张医生", "1", "口服", "0", "", "0", "0", "");
            details.add(detail1);
            response.setDetail(details);
            
            List<InsuranceDiseInfoDTO> diseInfos = new ArrayList<>();
            InsuranceDiseInfoDTO diseInfo = new InsuranceDiseInfoDTO("1", "1", "J00.001", 
                    "急性上呼吸道感染", "内科", "DOC001", "张医生", "2024-01-15 10:30:00", "1");
            diseInfos.add(diseInfo);
            response.setDiseinfolist(diseInfos);
            
            return InsuranceDetailResponse.success(response);
        } catch (Exception e) {
            return InsuranceDetailResponse.error("查询失败: " + e.getMessage());
        }
    }
}
