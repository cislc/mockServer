package com.inspur.medical.controller;

import com.inspur.medical.dto.ItemPriceQueryDTO;
import com.inspur.medical.dto.ItemPriceResponse;
import com.inspur.medical.entity.ItemPrice;
import com.inspur.medical.service.ItemPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class ItemPriceController {

    @Autowired
    private ItemPriceService itemPriceService;

    @PostMapping("/item/price")
    public ItemPriceResponse searchItemPrice(@RequestBody ItemPriceQueryDTO queryDTO) {
        try {
            List<ItemPrice> prices = itemPriceService.searchItemPrice(queryDTO.getItemType(), queryDTO.getAlias());
            return ItemPriceResponse.success(prices);
        } catch (Exception e) {
            return ItemPriceResponse.error("查询失败: " + e.getMessage());
        }
    }
}
