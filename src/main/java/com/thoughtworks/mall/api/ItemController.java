package com.thoughtworks.mall.api;

import com.thoughtworks.mall.domain.Item;
import com.thoughtworks.mall.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Validated
public class ItemController {
  @Autowired
  ItemRepository itemRepository;

  @CrossOrigin
  @GetMapping("/items")
  public ResponseEntity<List<Item>> getItemList() {
    List<Item> items = itemRepository.findAll().stream().map(
      item ->
        Item.builder()
          .name(item.getName())
          .pics(item.getPics())
          .price(item.getPrice())
          .itemUnit(item.getItemUnit())
          .build())
      .collect(Collectors.toList());
    System.out.println(itemRepository.findAll());
    return ResponseEntity.ok(items);
  }

}
