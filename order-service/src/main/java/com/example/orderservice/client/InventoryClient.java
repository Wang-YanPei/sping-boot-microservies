package com.example.orderservice.client;

import static com.example.orderservice.util.uri.IS_IN_STOCK_URI;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "inventory", url = "http://localhost:8082")
public interface InventoryClient {

    @RequestMapping(method = RequestMethod.GET, value = IS_IN_STOCK_URI)
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);
}
