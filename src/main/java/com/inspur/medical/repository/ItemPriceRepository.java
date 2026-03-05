package com.inspur.medical.repository;

import com.inspur.medical.entity.ItemPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemPriceRepository extends JpaRepository<ItemPrice, Long> {
    List<ItemPrice> findByItemDescContaining(String itemDesc);
    List<ItemPrice> findByItemCode(String itemCode);
}
