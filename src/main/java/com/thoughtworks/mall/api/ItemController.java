package com.thoughtworks.mall.api;

import com.thoughtworks.mall.domain.Item;
import com.thoughtworks.mall.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Validated
public class ItemController {
  @Autowired
  ItemRepository itemRepository;

  @GetMapping("/items")
  public ResponseEntity<List<Item>> getItemList() {
    List<Item> items = itemRepository.findAll().stream().map(
      item ->
        Item.builder().
          name(item.getName())
          .price(item.getPrice())
          .build())
      .collect(Collectors.toList());
    return ResponseEntity.ok(items);
  }

}
