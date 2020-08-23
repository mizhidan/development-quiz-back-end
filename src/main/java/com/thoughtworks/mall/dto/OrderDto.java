package com.thoughtworks.mall.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class OrderDto {
  @Id
  @GeneratedValue
  private Integer id;
  private String itemName;
  private int itemNumber;
  private String price;
  private String itemUnit;
}
