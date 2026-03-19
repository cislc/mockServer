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

}
