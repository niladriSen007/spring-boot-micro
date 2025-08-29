package com.niladri.order_service.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niladri.order_service.entity.Order;
import com.niladri.order_service.services.IOrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

  private final IOrderService orderService;

  public void createOrder(Order order) {
    orderService.createOrder(order);
  }

  public Order getOrderById(Long id) {
    return orderService.getOrderById(id);
  }

  public List<Order> getAllOrders() {
    return orderService.getAllOrders();
  }

  public void updateOrder(Long id, Order order) {
    orderService.updateOrder(id, order);
  }

  public void deleteOrder(Long id) {
    orderService.deleteOrder(id);
  }
}
