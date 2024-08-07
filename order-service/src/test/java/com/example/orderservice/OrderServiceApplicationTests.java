package com.example.orderservice;

import static com.example.orderservice.util.uri.PLACE_ORDER_URI;

import org.aspectj.weaver.ast.Or;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.testcontainers.containers.MySQLContainer;

import com.example.orderservice.dto.OrderRequest;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.math.BigDecimal;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0)
@AutoConfigureMockMvc
class OrderServiceApplicationTests {
    // private final String SKU_CODE = "cake";
    // private final Integer QUANTITY = 1;
    // private final BigDecimal PRICE = BigDecimal.valueOf(2.6);
    
    // @SuppressWarnings("rawtypes")
    // static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.3.0");
    // @LocalServerPort
    // private Integer port;
    // @Autowired
    // private ObjectMapper objectMapper;

    
    // @BeforeAll
    // static void BeforeAll(){
    //     mySQLContainer.start();
    // }

    // @AfterAll
    // static void AfterAll(){
    //     mySQLContainer.stop();
    // }

    // @BeforeEach
    // void setup() {
    //     RestAssured.baseURI = "http://localhost";
    //     RestAssured.port = port;
    // }

    // private OrderRequest getOrderRequest(){
    //     return OrderRequest.builder()
    //     .skuCode(SKU_CODE)
    //     .price(PRICE)
    //     .quantity(QUANTITY)
    //     .build();
    //   }

    // @Test
    // void shouldSubmitOrder() {
    //     OrderRequest orderRequest = getOrderRequest();

    //     String ordertRequestString = objectMapper.writeValueAsString(orderRequest);

    //     RestAssured.given()
    //             .contentType("application/json")
    //             .body(ordertRequestString)
    //             .when()
    //             .post(PLACE_ORDER_URI)
    //             .then()
    //             .log().all()
    //             .statusCode(201)
    //             .extract()
    //             .body().asString();
 
    // }
}

