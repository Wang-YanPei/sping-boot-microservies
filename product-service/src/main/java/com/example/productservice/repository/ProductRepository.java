package com.example.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.productservice.model.ProductEntity;

public interface ProductRepository extends MongoRepository<ProductEntity, String>{

}