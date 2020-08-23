package com.thoughtworks.mall.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
  private String itemName;
  private int itemNumber;
  private String price;
  private String itemUnit;
}
