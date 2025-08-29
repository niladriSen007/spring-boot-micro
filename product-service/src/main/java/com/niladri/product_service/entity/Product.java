package com.niladri.product_service.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "products")
public class Product {

  @Id
  private String id;

  /* @Column(nullable = false, name = "prod_name") */
  @NotBlank(message = "Product name is required")
  private String name;

  @NotBlank(message = "Product description is required")
  /* @Column(nullable = false, name = "prod_description") */
  private String description;

  @NotNull(message = "Product price is required")
  /* @Column(nullable = false, name = "prod_price") */
  private BigDecimal price;

  @NotNull(message = "Product discount is required")
 /*  @Column(nullable = false, name = "prod_discount") */
  private BigDecimal discount;

  @NotNull(message = "Product stock quantity is required")
  /* @Column(nullable = false, name = "prod_stock_quantity") */
  private Integer stockQuantity;
  
  /* @Column(name = "prod_image_url") */
  private String imageUrl;
  
  
  /* relations */
  @NotBlank(message = "Product category is required")
 /*  @JoinColumn(name = "prod_category_id",nullable = false)
  @ManyToOne(fetch = FetchType.LAZY) */
  private Category category;

}
