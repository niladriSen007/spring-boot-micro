package com.niladri.product_service.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.niladri.product_service.entity.Product;


@Repository
public interface ProductRepo extends MongoRepository<Product, String> {
//  List<Product> findByCategory(String category);
}
