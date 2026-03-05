package com.inspur.medical.service;

import com.inspur.medical.entity.ItemPrice;
import com.inspur.medical.repository.ItemPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
public class ItemPriceService {

    @Autowired
    private ItemPriceRepository itemPriceRepository;

    private static final Random random = new Random();

    public List<ItemPrice> searchItemPrice(String itemType, String alias) {
        if (alias != null && !alias.isEmpty()) {
            return itemPriceRepository.findByItemDescContaining(alias);
        }
        return itemPriceRepository.findAll();
    }

    @Transactional
    public void generateMockPrices() {
        String[] items = {
            "血常规", "尿常规", "肝功能", "肾功能", "心电图",
            "胸部X光", "CT检查", "核磁共振", "B超检查", "阿莫西林",
            "头孢克肟", "布洛芬", "对乙酰氨基酚", "维生素C", "钙片"
        };
        
        String[] factories = {
            "上海医药集团", "北京同仁堂", "广州医药", "江苏恒瑞", "浙江海正"
        };
        
        for (int i = 0; i < items.length; i++) {
            ItemPrice price = new ItemPrice();
            
            price.setSerialNo(String.format("SN%05d", i + 1));
            price.setItemDesc(items[i]);
            price.setItemCode("ITEM" + String.format("%04d", i + 1));
            price.setPricesNo("PN" + String.format("%06d", i + 1));
            price.setUom("次");
            
            double basePrice = 10 + random.nextInt(500);
            price.setPrice(String.format("%.2f", basePrice));
            price.setSpecialPrice(String.format("%.2f", basePrice * 0.9));
            
            price.setFactory(factories[random.nextInt(factories.length)]);
            price.setContentDesc(items[i] + "检查/治疗");
            price.setChargeStandard("国家标准");
            price.setInsureSign(random.nextBoolean() ? "1" : "0");
            price.setRegistrationNo("国药准字" + String.format("H%08d", random.nextInt(100000000)));
            price.setRegExpDate(String.format("2025-%02d-%02d", 1 + random.nextInt(12), 1 + random.nextInt(28)));
            
            itemPriceRepository.save(price);
        }
    }
}
