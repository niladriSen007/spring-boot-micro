package com.niladri.order_service.services;

import java.util.List;

import com.niladri.order_service.entity.Order;

public interface IOrderService {
  Order createOrder(Order order);
  Order getOrderById(Long id);
  List<Order> getAllOrders();
  void updateOrder(Long id, Order order);
  void deleteOrder(Long id);
}
