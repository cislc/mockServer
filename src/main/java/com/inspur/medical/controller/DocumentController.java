package com.inspur.medical.controller;

import com.inspur.medical.dto.ElectronicDocumentQueryDTO;
import com.inspur.medical.dto.ElectronicDocumentResponse;
import com.inspur.medical.dto.PrintStatusDTO;
import com.inspur.medical.dto.PrintStatusResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @PostMapping("/electronic")
    public ElectronicDocumentResponse getElectronicDocument(@RequestBody ElectronicDocumentQueryDTO queryDTO) {
        try {
            String pdfUrl = "/api/mock-pdf/sample.pdf";
            return ElectronicDocumentResponse.success("P00001", "张三", "男", queryDTO.getCardType(), pdfUrl);
        } catch (Exception e) {
            return ElectronicDocumentResponse.error("获取失败: " + e.getMessage());
        }
    }

    @PostMapping("/electronic/status")
    public PrintStatusResponse updateElectronicDocumentStatus(@RequestBody PrintStatusDTO requestDTO) {
        return PrintStatusResponse.success();
    }
}
