package com.example.inventoryservice.repository;

import com.example.inventoryservice.model.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<InventoryEntity, Long> {

    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, int quantity);
}