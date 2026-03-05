package com.inspur.medical.controller;

import com.inspur.medical.dto.ElectronicDocumentQueryDTO;
import com.inspur.medical.dto.ElectronicDocumentResponse;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @PostMapping("/electronic")
    public ElectronicDocumentResponse getElectronicDocument(@RequestBody ElectronicDocumentQueryDTO queryDTO) {
        try {
            String pdfUrl = "http://example.com/documents/electronic_" + System.currentTimeMillis() + ".pdf";
            return ElectronicDocumentResponse.success("P00001", "张三", "男", queryDTO.getCardType(), pdfUrl);
        } catch (Exception e) {
            return ElectronicDocumentResponse.error("获取失败: " + e.getMessage());
        }
    }

    @PostMapping("/electronic/status")
    public Map<String, Object> updateElectronicDocumentStatus(@RequestBody Map<String, String> request) {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> head = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        
        head.put("token", "");
        body.put("ResultCode", "1");
        body.put("ResultContent", "状态更新成功");
        
        response.put("head", head);
        response.put("body", body);
        return response;
    }
}
