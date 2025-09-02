package com.niladri.order_service.payload.dto;

import java.math.BigDecimal;

public record CreateOrder(Long id, String orderNumber, String skuCode,
    BigDecimal price, Integer quantity, UserDetails userDetails) {
}
