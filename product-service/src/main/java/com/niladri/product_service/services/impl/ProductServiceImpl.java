package com.niladri.product_service.services.impl;

import com.niladri.product_service.entity.Product;
import com.niladri.product_service.payload.requests.CreateProductDto;
import com.niladri.product_service.repositories.ProductRepo;
import com.niladri.product_service.services.IProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements IProductService {
  

    private final ProductRepo productRepo;

  @Override
  public Product createProduct(CreateProductDto product) {
    Product prod = Product.builder()
        .name(product.name())
        .description(product.description())
        .price(product.price())
        .discount(product.discount())
        .stockQuantity(product.stockQuantity())
        .category(null) // You need to map CategoryDto to Category entity
        .build();
      productRepo.save(prod);
      log.info("Product created successfully");
    return prod;
  }

  @Override
  public List<Product> getAllProducts() {
    // Implement the logic to get all products
    return productRepo.findAll();
  }

  @Override
  public Product getProductById(Long id) {
    // Implement the logic to get a product by id
    return null;
  }

  @Override
  public Product updateProduct(Long id, Product product) {
    // Implement the logic to update a product
    return null;
  }

  @Override
  public void deleteProduct(Long id) {
    // Implement the logic to delete a product
  }
}
