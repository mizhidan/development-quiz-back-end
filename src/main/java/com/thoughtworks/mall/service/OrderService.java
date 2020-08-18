package com.thoughtworks.mall.service;

import com.thoughtworks.mall.domain.Order;
import com.thoughtworks.mall.dto.OrderDto;
import com.thoughtworks.mall.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
  final OrderRepository orderRepository;

  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public void saveOrder(Order order) {
    OrderDto orderDto = orderRepository.findByItemName(order.getItemName());
    if(orderDto == null) {
      orderRepository.save( OrderDto
        .builder()
        .itemName(order.getItemName())
        .itemNumber(order.getItemNumber())
        .build());
    } else {
      orderDto.setItemNumber(orderDto.getItemNumber() + 1);
      orderRepository.save(orderDto);
    }
  }
}
