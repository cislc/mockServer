package com.inspur.medical.controller;

import com.inspur.medical.dto.ElectronicInvoiceDTO;
import com.inspur.medical.dto.ElectronicInvoiceQueryDTO;
import com.inspur.medical.dto.ElectronicInvoiceResponse;
import com.inspur.medical.dto.PrintStatusDTO;
import com.inspur.medical.dto.PrintStatusResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/invoicing")
public class InvoicingController {

    private static final Random random = new Random();

    @PostMapping("/electronic")
    public ElectronicInvoiceResponse getElectronicInvoice(@RequestBody ElectronicInvoiceQueryDTO queryDTO) {
        try {
            List<ElectronicInvoiceDTO> lisInvoices = new ArrayList<>();
            
            ElectronicInvoiceDTO invoice1 = new ElectronicInvoiceDTO("PAY" + System.currentTimeMillis(),
                                                                      "BIZ001",
                                                                      "INV" + System.currentTimeMillis(),
                                                                      "EINV" + System.currentTimeMillis(),
                                                                      String.valueOf(1000 + random.nextInt(9000)),
                                                                      "0",
                                                                      "/api/mock-pdf/sample.pdf",
                                                                      "2024-01-15");
            ElectronicInvoiceDTO invoice2 = new ElectronicInvoiceDTO("PAY" + (System.currentTimeMillis() - 100000),
                                                                      "BIZ002",
                                                                      "INV" + (System.currentTimeMillis() - 100000),
                                                                      "EINV" + (System.currentTimeMillis() - 100000),
                                                                      String.valueOf(1000 + random.nextInt(9000)),
                                                                      "0",
                                                                      "/api/mock-pdf/sample.pdf",
                                                                      "2024-01-14");
            lisInvoices.add(invoice1);
            lisInvoices.add(invoice2);
            
            return ElectronicInvoiceResponse.success(lisInvoices);
        } catch (Exception e) {
            return ElectronicInvoiceResponse.error("查询失败: " + e.getMessage());
        }
    }

    @PostMapping("/electronic/status")
    public PrintStatusResponse updateElectronicInvoiceStatus(@RequestBody PrintStatusDTO requestDTO) {
        return PrintStatusResponse.success();
    }
}
