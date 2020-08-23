package com.thoughtworks.mall.api;

import com.thoughtworks.mall.domain.Item;
import com.thoughtworks.mall.dto.ItemDto;
import com.thoughtworks.mall.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

  @CrossOrigin
  @PostMapping("/items")
  public ResponseEntity<String> addItemToList(@RequestBody Item item) {
    List<ItemDto> itemDtoList = itemRepository.findAll();
    for ( ItemDto itemDto : itemDtoList) {
      if (itemDto.getItemUnit().equals(item.getItemUnit()) &&
        itemDto.getName().equals(item.getName()) &&
        itemDto.getPrice().equals(item.getPrice())) {
        return ResponseEntity.badRequest().build();
      }
    }
    ItemDto itemDto = ItemDto.builder()
      .name(item.getName())
      .pics(item.getPics())
      .price(item.getPrice())
      .itemUnit(item.getItemUnit()).build();
    itemRepository.save(itemDto);
    return ResponseEntity.ok().build();
  }
}
