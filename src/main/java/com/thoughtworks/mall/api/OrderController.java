package com.thoughtworks.mall.api;

import com.thoughtworks.mall.domain.Order;
import com.thoughtworks.mall.service.OrderService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
