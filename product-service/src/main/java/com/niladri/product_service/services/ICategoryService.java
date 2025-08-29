package com.niladri.product_service.services;

import com.niladri.product_service.entity.Category;

public interface ICategoryService {
  Category createCategory(Category category);
  Category getCategoryById(Long categoryId);
  Category updateCategory(Long categoryId, Category category);
  void deleteCategory(Long categoryId);
}
