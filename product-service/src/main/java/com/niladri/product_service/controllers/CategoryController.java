package com.niladri.product_service.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {


    @PostMapping("/")
    public ResponseEntity<String> addCategory(@RequestBody String category) {
        return ResponseEntity.ok("Category added successfully");
    }

    public List<String> getAllCategories() {
        return List.of("Electronics", "Clothing", "Books", "Home & Kitchen", "Sports & Fitness");
    }
}
