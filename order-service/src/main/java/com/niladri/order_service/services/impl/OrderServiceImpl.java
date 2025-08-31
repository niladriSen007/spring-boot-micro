package com.niladri.order_service.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.niladri.order_service.entity.Order;
import com.niladri.order_service.repository.OrderRepository;
import com.niladri.order_service.services.IOrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {

  private final OrderRepository orderRepository;

  @Override
  public Order createOrder(Order order) {
    Order newOrder = Order
        .builder()
        .totalPrice(order.getTotalPrice())
        .orderStatus(order.getOrderStatus())
        .items(order.getItems())
        .build();
    return orderRepository.save(newOrder);
  }

  @Override
  public Order getOrderById(Long id) {
    return orderRepository.findById(id).orElse(null);
  }

  @Override
  public List<Order> getAllOrders() {
    return orderRepository.findAll();
  }

  @Override
  public void updateOrder(Long id, Order order) {
    // Implementation here
  }

  @Override
  public void deleteOrder(Long id) {
    // Implementation here
  }
}
