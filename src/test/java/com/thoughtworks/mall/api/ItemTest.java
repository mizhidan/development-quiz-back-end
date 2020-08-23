package com.thoughtworks.mall.api;

import com.thoughtworks.mall.domain.Item;
import com.thoughtworks.mall.dto.ItemDto;
import com.thoughtworks.mall.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ItemTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ItemRepository itemRepository;
    private ItemDto itemDto;

    @BeforeEach
    void setUp() {
        itemDto = ItemDto.builder()
          .name("冰红茶")
          .price("1")
          .build();
    }

    @Test
    public void should_get_item() throws Exception {
        itemRepository.save(itemDto);
        mockMvc.perform(get("/items"))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("冰红茶")))
                .andExpect(jsonPath("$[0].price", is("1")))
                .andExpect(status().isOk());
    }

    @Test
    public void should_add_item() throws Exception {
        Item item = Item.builder()
          .name("红牛")
          .pics("abc.com")
          .price("5")
          .itemUnit("罐").build();
        ItemDto itemDto = ItemDto.builder()
          .name(item.getName())
          .pics(item.getPics())
          .price(item.getPrice())
          .itemUnit(item.getItemUnit()).build();
        itemRepository.save(itemDto);
        mockMvc.perform(get("/items"))
          .andExpect(jsonPath("$", hasSize(5)))
          .andExpect(jsonPath("$[4].name", is("红牛")))
          .andExpect(jsonPath("$[4].price", is("5")))
          .andExpect(jsonPath("$[4].pics",is("abc.com")))
          .andExpect(status().isOk());
    }
}
