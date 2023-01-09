package com.juke.productservice.entity;

import com.juke.productservice.entity.base.BaseEntity;
import com.juke.productservice.entity.enums.CategoryEnum;
import com.juke.productservice.entity.enums.MeasureEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "products")
@Entity
public class ProductEntity extends BaseEntity {

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "description", nullable = false)
  private String description;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "measure")
  private MeasureEnum measure;

  @Column(name = "quantity", nullable = false)
  private Double quantity;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "category")
  private CategoryEnum category;


  @Builder
  public ProductEntity(
      Long id,
      LocalDateTime createdAt,
      LocalDateTime modifiedAt,
      String name,
      String description,
      MeasureEnum measure,
      Double quantity,
      CategoryEnum category
  ) {
    super(id, createdAt, modifiedAt);
    this.name = name;
    this.description = description;
    this.measure = measure;
    this.quantity = quantity;
    this.category = category;
  }
}