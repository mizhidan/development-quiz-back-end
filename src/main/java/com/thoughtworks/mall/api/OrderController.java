package com.thoughtworks.mall.api;

import com.thoughtworks.mall.domain.Order;
import com.thoughtworks.mall.dto.OrderDto;
import com.thoughtworks.mall.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

  final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @CrossOrigin
  @PostMapping("/orders")
  public void saveOrder(@RequestBody Order order) {
    orderService.saveOrder(order);
  }

  @CrossOrigin
  @GetMapping("/orders")
  public ResponseEntity<List<OrderDto>> getOrders() {
    return ResponseEntity.ok(orderService.getOrders());
  }
}
