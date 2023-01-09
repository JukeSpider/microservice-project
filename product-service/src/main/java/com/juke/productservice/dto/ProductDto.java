package com.juke.productservice.dto;

import com.juke.productservice.dto.base.BaseDto;
import com.juke.productservice.entity.enums.CategoryEnum;
import com.juke.productservice.entity.enums.MeasureEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductDto extends BaseDto {

  private String name;

  private String description;

  private String measure;

  private Double quantity;

  private String category;

  @Builder
  public ProductDto(
      Long id,
      String createdAt,
      String modifiedAt,
      String name,
      String description,
      String measure,
      Double quantity,
      String category
  ) {
    super(id, createdAt, modifiedAt);
    this.name = name;
    this.description = description;
    this.measure = measure;
    this.quantity = quantity;
    this.category = category;
  }
}