package com.niladri.product_service.entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
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
@Document(collection = "categories")
public class Category {

  @Id
  private String id;

  /* @Column(nullable = false, unique = true) */
  @NotBlank(message = "Category name is required")
  private String name;

 /*  @OneToMany(mappedBy = "category",fetch = FetchType.LAZY) */
  private Set<Product> products;

}
