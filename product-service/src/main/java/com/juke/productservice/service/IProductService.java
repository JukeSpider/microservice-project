package com.juke.productservice.service;

import com.juke.productservice.entity.ProductEntity;
import java.util.Collection;

public interface IProductService {

  Collection<ProductEntity> findAll();

  Collection<ProductEntity> findAllByCategory(String category);

  ProductEntity findById(Long id);

  ProductEntity findByName(String name);

  ProductEntity save(ProductEntity product);

  Collection<ProductEntity> saveAll(Collection<ProductEntity> productColl);

  ProductEntity updateById(Long id, ProductEntity product);

  ProductEntity updateByName(String name, ProductEntity product);

  boolean deleteById(Long id);

  boolean deleteByName(String name);
}