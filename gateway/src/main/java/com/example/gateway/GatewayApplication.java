package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;


@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}


	// @Bean
	// public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
	// 	return builder.routes()
	// 	.route("product_service", // 给路由起一个唯一的名称
	// 			r -> r.path("/api/product/**") // 匹配请求路径
	// 				  .uri("http://localhost:8080") // 转发的目标地址
	// 	)
	// 	.route("order_service",
	// 	        r -> r.path("/api/order/placeOrder")
	// 			      .uri("http://localhost:8081")//这里通配符没有生效，只能像这样写全路径
	// 	)
	// 	.route("inventory_service",
	// 	        r -> r.path("api/inventory/**")
	// 	              .uri("http://localhost:8082")
	// 	)
	// 	.build();
				
	// }
}
