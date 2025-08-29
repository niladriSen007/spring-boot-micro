package com.niladri.product_service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;
import com.niladri.product_service.entity.Product;
import com.niladri.product_service.payload.requests.CreateProductDto;
import com.niladri.product_service.services.IProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

  private final IProductService productService;


  @PostMapping("/")
  @ResponseStatus(HttpStatus.CREATED)
  public Product createProduct(@RequestBody CreateProductDto productDto) {
    return productService.createProduct(productDto);
  }

  @GetMapping("/")
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

}
