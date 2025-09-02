package com.niladri.order_service.client;


import com.niladri.order_service.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "product-service", path = "/products")
public interface ProductFeignClient {

    @PutMapping("/products/reduce-stocks")  //use same path and mapping
    Double reduceStocks(@RequestBody Order orderRequestDto);
}
