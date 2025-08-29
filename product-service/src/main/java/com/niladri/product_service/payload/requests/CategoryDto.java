package com.niladri.product_service.payload.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDto {
  private String name;
}
