package com.juke.productservice.mapper;

import com.juke.productservice.dto.ProductDto;
import com.juke.productservice.entity.ProductEntity;
import com.juke.productservice.entity.enums.CategoryEnum;
import com.juke.productservice.entity.enums.MeasureEnum;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements IBaseMapper<ProductEntity, ProductDto> {

  @Override
  public ProductDto toDto(ProductEntity entity) {

    if (entity == null) {
      return null;
    }

    return ProductDto.builder()
        .id(entity.getId())
        .createdAt(entity.getCreatedAt() == null ? null : entity.getCreatedAt().toString())
        .modifiedAt(entity.getModifiedAt() == null ? null : entity.getModifiedAt().toString())
        .name(entity.getName())
        .description(entity.getDescription())
        .measure(entity.getMeasure().name())
        .quantity(entity.getQuantity())
        .category(entity.getCategory().name())
        .build();
  }

  @Override
  public ProductEntity toEntity(ProductDto dto) {

    if (dto == null) {
      return null;
    }

    return ProductEntity.builder()
        .id(dto.getId())
        .createdAt(dto.getCreatedAt() == null ? null : LocalDateTime.parse(dto.getCreatedAt()))
        .modifiedAt(dto.getModifiedAt() == null ? null : LocalDateTime.parse(dto.getModifiedAt()))
        .name(dto.getName())
        .description(dto.getDescription())
        .measure(MeasureEnum.valueOf(dto.getMeasure()))
        .quantity(dto.getQuantity())
        .category(CategoryEnum.valueOf(dto.getCategory()))
        .build();
  }

  @Override
  public Collection<ProductDto> toDtoColl(Collection<ProductEntity> entityColl) {

    if (entityColl == null || entityColl.isEmpty()) {
      return Collections.emptyList();
    }

    Collection<ProductDto> dtoColl = new ArrayList<>(entityColl.size());

    for (ProductEntity entity : entityColl) {
      dtoColl.add(this.toDto(entity));
    }

    return dtoColl;
  }

  @Override
  public Collection<ProductEntity> toEntityColl(Collection<ProductDto> dtoColl) {

    if (dtoColl == null || dtoColl.isEmpty()) {
      return Collections.emptyList();
    }

    Collection<ProductEntity> entityColl = new ArrayList<>(dtoColl.size());

    for (ProductDto dto : dtoColl) {
      entityColl.add(this.toEntity(dto));
    }

    return entityColl;
  }
}