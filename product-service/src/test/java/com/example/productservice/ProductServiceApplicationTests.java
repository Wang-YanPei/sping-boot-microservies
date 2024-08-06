package com.example.productservice;

import static com.example.productservice.util.uri.CREATE_PRODUCT_URI;
import static com.example.productservice.util.uri.GET_ALL_PRODUCTS_URI;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.example.productservice.dto.ProductRequest;
import com.example.productservice.repository.ProductRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import java.math.BigDecimal;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ProductServiceApplicationTests {
    private final String NAME = "cake";
    private final String DESCRIPTION = "apple favor";
    private final BigDecimal PRICE = BigDecimal.valueOf(2.6);
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");

    private ProductRequest getProductRequest() {
        return ProductRequest.builder()
                .name(NAME)
                .description(DESCRIPTION)
                .price(PRICE)
                .build();
    }


    @BeforeAll
    static void BeforeAll(){
        mongoDBContainer.start();
    }

    @AfterAll
    static void AfterAll(){
        mongoDBContainer.stop();
    }

    @Test
    void shouldCreateProduct() throws Exception {
        ProductRequest productRequest = getProductRequest();

        String productRequestString = objectMapper.writeValueAsString(productRequest);

        mockMvc.perform(MockMvcRequestBuilders.post(CREATE_PRODUCT_URI)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(productRequestString))
                .andExpect(status().isCreated());

        Assertions.assertTrue(productRepository.count() >= 1L);
    }


    @Test
    void shouldFindAll() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get(GET_ALL_PRODUCTS_URI))
                .andExpect(status().isOk());
        Assertions.assertTrue(productRepository.count() >= 1L);
    }
}
