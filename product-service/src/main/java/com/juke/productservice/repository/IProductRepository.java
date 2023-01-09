package com.juke.productservice.repository;

import com.juke.productservice.entity.ProductEntity;
import com.juke.productservice.entity.enums.CategoryEnum;
import java.util.Collection;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<ProductEntity, Long> {

  Collection<ProductEntity> findAllByCategory(CategoryEnum category);

  Optional<ProductEntity> findByName(String name);

  void deleteByName(String name);

  boolean existsById(Long id);

  boolean existsByName(String name);
}