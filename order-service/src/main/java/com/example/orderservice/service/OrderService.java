package com.example.orderservice.service;

import static com.example.orderservice.util.ErrorMessage.PRODUCT_IS_NOT_IN_STOCK;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.orderservice.client.InventoryClient;
import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.model.OrderEntity;
import com.example.orderservice.model.OrderLineItemsEntity;
import com.example.orderservice.repository.OrderRepository;

import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Service class to handle order processing logic.
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;


     /**
     * Places an order based on the provided OrderRequest.
     *
     * @param orderRequest The OrderRequest containing order details.
     */

    @Transactional
    public void placeOrder(OrderRequest orderRequest) {

        boolean isProductInStock = inventoryClient.isInStock(orderRequest.getSkuCode(), orderRequest.getQuantity());

        if(isProductInStock){
            OrderEntity order = OrderEntity.builder()
            .orderNumber(UUID.randomUUID().toString())
            .skuCode(orderRequest.getSkuCode())
            .price(orderRequest.getPrice())
            .quantity(orderRequest.getQuantity())
            .build();

            orderRepository.save(order);

        }else{
            throw new RuntimeException(String.format(PRODUCT_IS_NOT_IN_STOCK, orderRequest.getSkuCode()));
        }
     

    }
}
