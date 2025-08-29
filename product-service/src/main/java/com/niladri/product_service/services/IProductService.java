package com.niladri.product_service.services;

import java.util.List;

import com.niladri.product_service.entity.Product;
import com.niladri.product_service.payload.requests.CreateProductDto;

public interface IProductService {
  // Define your service methods here
  Product createProduct(CreateProductDto product);
  Product getProductById(Long id);
  List<Product> getAllProducts();
  Product updateProduct(Long id, Product product);
  void deleteProduct(Long id);
}
