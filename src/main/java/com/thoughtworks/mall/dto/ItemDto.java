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
@Table(name = "items")
public class ItemDto {
  @Id
  @GeneratedValue
  private int id;
  private String name;
  private String pics;
  private String price;
  private String itemUnit;
}
