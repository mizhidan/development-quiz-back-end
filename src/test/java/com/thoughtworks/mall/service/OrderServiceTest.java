package com.thoughtworks.mall.service;

import com.thoughtworks.mall.domain.Order;
import com.thoughtworks.mall.dto.OrderDto;
import com.thoughtworks.mall.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderServiceTest {
  OrderService orderService;

  @Mock
  OrderRepository orderRepository;
  Order order;

  @BeforeEach
  void setup() {
    initMocks(this);
    orderService = new OrderService(orderRepository);
    order = Order.builder().itemName("冰红茶").itemNumber(1).build();
  }

  @Test
  public void should_add_order_to_database() {
    OrderDto orderDto = OrderDto.builder().itemName(order.getItemName()).itemNumber(order.getItemNumber()).build();
    orderService.saveOrder(order);
    verify(orderRepository).save(orderDto);
  }

  @Test
  public void should_get_orders() {
    orderService.saveOrder(order);
    orderService.getOrders();
    verify(orderRepository).findAll();
  }
}
