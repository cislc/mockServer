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
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/lab")
public class LabController {

    private static final List<String> PDF_URLS = Arrays.asList(
            "/browser/medical-docs/%E5%A4%9A%E7%BB%86%E8%83%9E%E5%A4%8D%E6%9D%82%E7%B3%BB%E7%BB%9F%E7%9A%84%E5%8C%96%E5%AD%A6%E4%B8%8E%E7%94%9F%E7%89%A9%E5%8F%8A%E5%8C%BB%E5%AD%A6%E4%BA%A4%E5%8F%89%E5%89%8D%E6%B2%BF_%E9%99%88%E5%AD%90%E5%A2%A8.pdf",
            "/browser/medical-docs/%E5%9F%BA%E4%BA%8E%E5%A4%A7%E8%AF%AD%E8%A8%80%E6%A8%A1%E5%9E%8B%E7%9A%84%E6%99%BA%E8%83%BD%E7%97%85%E5%8E%86%E5%AE%A1%E6%A0%B8%E5%8A%A9%E6%89%8B%E8%AE%BE%E8%AE%A1%E4%B8%8E%E5%AE%9E%E7%8E%B0_%E5%90%B4%E6%80%9D%E8%B0%9A.pdf",
            "/browser/medical-docs/%E5%9F%BA%E4%BA%8E%E4%BA%BA%E5%B7%A5%E6%99%BA%E8%83%BD%E6%B7%B1%E5%BA%A6%E5%AD%A6%E4%B9%A0%E7%AE%97%E6%B3%95%E7%9A%84%E5%85%A8%E6%B5%81%E7%A8%8B%E7%97%85%E5%8E%86%E8%87%AA%E5%8A%A8%E5%8C%96%E7%9B%91%E6%B5%8B%E7%B3%BB%E7%BB%9F_%E7%BD%97%E6%98%8E.pdf",
            "/browser/medical-docs/%E5%B8%82%E5%9C%BA%E4%BA%A4%E6%98%93%E6%A8%A1%E5%BC%8F%E5%AF%B9%E5%8C%BB%E7%96%97%E5%81%A5%E5%BA%B7%E6%95%B0%E6%8D%AE%E4%BB%B7%E5%80%BC%E5%AE%9E%E7%8E%B0%E7%9A%84%E4%BD%9C%E7%94%A8_%E7%90%9A%E6%96%87%E8%83%9C.pdf",
            "/browser/medical-docs/%E5%8C%BB%E7%96%97%E6%95%B0%E6%8D%AE%E8%B5%84%E4%BA%A7%E7%9A%84%E8%B4%A8%E9%87%8F%E8%AF%84%E4%BC%B0%E7%A0%94%E7%A9%B6%E2%80%94%E2%80%94%E4%BB%A5%E8%84%91%E8%A1%80%E7%AE%A1%E7%97%85%E6%82%A3%E8%80%85%E8%AF%8A%E7%96%97%E6%95%B0%E6%8D%AE%E4%B8%BA%E4%BE%8B_%E5%85%B0%E8%93%9D.pdf"
    );
    private static final Random RANDOM = new Random();

    private String getRandomPdfUrl() {
        return PDF_URLS.get(RANDOM.nextInt(PDF_URLS.size()));
    }

    @PostMapping("/reportpdf")
    public LabReportResponse getLabReportPdf(@RequestBody LabReportQueryDTO queryDTO) {
        try {
            List<LabReportDTO> lisReports = new ArrayList<>();
            
            LabReportDTO report1 = new LabReportDTO("RPT" + System.currentTimeMillis(), 
                                                     "2024-01-15", "10:30:00",
                                                     getRandomPdfUrl(),
                                                     "血常规检验", "0", "LAB001");
            LabReportDTO report2 = new LabReportDTO("RPT" + (System.currentTimeMillis() - 100000), 
                                                     "2024-01-14", "14:20:00",
                                                     getRandomPdfUrl(),
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
                                                        getRandomPdfUrl(),
                                                        "X光检查", "0", "CHK001");
            CheckReportDTO report2 = new CheckReportDTO("CHK" + (System.currentTimeMillis() - 100000), 
                                                        "2024-01-14", "15:30:00",
                                                        getRandomPdfUrl(),
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
