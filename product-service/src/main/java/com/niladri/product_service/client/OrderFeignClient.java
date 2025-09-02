package com.niladri.product_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "order-service", path = "/orders")
public interface OrderFeignClient {
  @GetMapping("/core/helloOrders") // use same path and mapping
  String helloOrders();
}
