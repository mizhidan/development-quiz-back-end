package com.thoughtworks.mall.repository;

import com.thoughtworks.mall.dto.OrderDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<OrderDto, String> {
  @Override
  List<OrderDto> findAll();

  OrderDto findByItemName(String itemName);
}
