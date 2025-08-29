package com.niladri.product_service.payload.requests;

import java.math.BigDecimal;

public record CreateProductDto(
    String name,
    String description,
    BigDecimal price,
    BigDecimal discount,
    Integer stockQuantity,
    /* String imageUrl, */
    String category) {
}
