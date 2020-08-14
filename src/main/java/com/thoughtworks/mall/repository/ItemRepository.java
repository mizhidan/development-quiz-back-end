package com.thoughtworks.mall.repository;

import com.thoughtworks.mall.dto.ItemDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<ItemDto, Integer> {
    @Override
    List<ItemDto> findAll();
}
