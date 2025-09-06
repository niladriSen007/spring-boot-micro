package com.niladri.order_service.controllers;

import com.niladri.order_service.entity.Order;
import com.niladri.order_service.services.IOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/core")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final IOrderService orderService;

    @PostMapping("/")
    public void createOrder(@RequestBody Order order) {
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


    @GetMapping("/helloOrders")
    public String helloOrders(@RequestHeader("X-User-Id") long userId) {
        return "Hello from OrderService" + userId;
    }

}
