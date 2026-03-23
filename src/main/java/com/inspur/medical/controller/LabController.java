package com.inspur.medical.controller;

import com.inspur.medical.dto.CheckReportDTO;
import com.inspur.medical.dto.CheckReportQueryDTO;
import com.inspur.medical.dto.CheckReportResponse;
import com.inspur.medical.dto.LabReportDTO;
import com.inspur.medical.dto.LabReportQueryDTO;
import com.inspur.medical.dto.LabReportResponse;
import com.inspur.medical.dto.PrintStatusDTO;
import com.inspur.medical.dto.PrintStatusResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lab")
public class LabController {

    @PostMapping("/reportpdf")
    public LabReportResponse getLabReportPdf(@RequestBody LabReportQueryDTO queryDTO) {
        try {
            List<LabReportDTO> lisReports = new ArrayList<>();
            
            LabReportDTO report1 = new LabReportDTO("RPT" + System.currentTimeMillis(), 
                                                     "2024-01-15", "10:30:00",
                                                     "/api/mock-pdf/sample.pdf",
                                                     "血常规检验", "0", "LAB001");
            LabReportDTO report2 = new LabReportDTO("RPT" + (System.currentTimeMillis() - 100000), 
                                                     "2024-01-14", "14:20:00",
                                                     "/api/mock-pdf/sample.pdf",
                                                     "尿常规检验", "0", "LAB002");
            lisReports.add(report1);
            lisReports.add(report2);
            
            return LabReportResponse.success(lisReports);
        } catch (Exception e) {
            return LabReportResponse.error("查询失败: " + e.getMessage());
        }
    }

    @PostMapping("/reportpdf/status")
    public PrintStatusResponse updateLabReportStatus(@RequestBody PrintStatusDTO requestDTO) {
        return PrintStatusResponse.success();
    }

    @PostMapping("/checkpdf")
    public CheckReportResponse getCheckReportPdf(@RequestBody CheckReportQueryDTO queryDTO) {
        try {
            List<CheckReportDTO> lisReports = new ArrayList<>();
            
            CheckReportDTO report1 = new CheckReportDTO("CHK" + System.currentTimeMillis(), 
                                                        "2024-01-15", "11:00:00",
                                                        "/api/mock-pdf/sample.pdf",
                                                        "X光检查", "0", "CHK001");
            CheckReportDTO report2 = new CheckReportDTO("CHK" + (System.currentTimeMillis() - 100000), 
                                                        "2024-01-14", "15:30:00",
                                                        "/api/mock-pdf/sample.pdf",
                                                        "B超检查", "0", "CHK002");
            lisReports.add(report1);
            lisReports.add(report2);
            
            return CheckReportResponse.success(lisReports);
        } catch (Exception e) {
            return CheckReportResponse.error("查询失败: " + e.getMessage());
        }
    }

    @PostMapping("/checkpdf/status")
    public PrintStatusResponse updateCheckReportStatus(@RequestBody PrintStatusDTO requestDTO) {
        return PrintStatusResponse.success();
    }
}
