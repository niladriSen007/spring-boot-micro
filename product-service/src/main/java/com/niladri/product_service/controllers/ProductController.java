package com.niladri.product_service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;

import com.niladri.product_service.client.OrderFeignClient;
import com.niladri.product_service.entity.Product;
import com.niladri.product_service.payload.requests.CreateProductDto;
import com.niladri.product_service.services.IProductService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/core")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

  private final IProductService productService;
  /*
   * private final DiscoveryClient discoveryClient;
   * private final RestClient restClient;
   */

  private final OrderFeignClient orderFeignClient;

  @PostMapping("/")
  @ResponseStatus(HttpStatus.CREATED)
  public Product createProduct(@RequestBody CreateProductDto productDto) {
    return productService.createProduct(productDto);
  }

  @GetMapping("/")
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

  @GetMapping("/fetchOrder")
  public String fetchOrder() {
    /* log.info(request.getHeader("X-Custom-Header")); */
    /*
     * ServiceInstance orderService =
     * discoveryClient.getInstances("order-service").getFirst();
     * return restClient.get().uri(orderService.getUri() +
     * "/orders/core/helloOrders").retrieve().body(String.class);
     */

    return orderFeignClient.helloOrders();
  }

}
