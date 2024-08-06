package com.example.productservice.service;

import static com.example.productservice.util.CommonInfo.PRODUCT_SAVED_INFO;
import com.example.productservice.dto.ProductRequest;
import com.example.productservice.dto.ProductResponse;
import com.example.productservice.model.ProductEntity;
import com.example.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * Creates a new product entry based on the provided product request.
     * 
     * @param ProductRequest The product request object containing product details. Must not be null.
     * @throws IllegalArgumentException If productRequest is null.
     */
    public void createProduct(@NonNull ProductRequest productRequest) {
        ProductEntity product = ProductEntity.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info(String.format(PRODUCT_SAVED_INFO, product.getId()));
    }

    /**
     * Get all product entries.
     * 
     * @return All product entries.
     */
    public List<ProductResponse> getAllProducts() {
        List<ProductEntity> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    /**
     * Conver ProductEntity to ProductResponse.
     * 
     * @param ProductEntity The product entity object containing original product details
     * @return ProductRequest The product request object containing product details
     */
    private ProductResponse mapToProductResponse(ProductEntity product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}