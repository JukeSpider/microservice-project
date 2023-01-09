package com.juke.productservice.service.impl;

import com.juke.productservice.entity.ProductEntity;
import com.juke.productservice.entity.enums.CategoryEnum;
import com.juke.productservice.repository.IProductRepository;
import com.juke.productservice.service.IProductService;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements IProductService {

  private final IProductRepository repository;

  @Override
  public Collection<ProductEntity> findAll() {
    return repository.findAll();
  }

  @Override
  public Collection<ProductEntity> findAllByCategory(String category) {
    return repository.findAllByCategory(CategoryEnum.valueOf(category));
  }

  @Override
  public ProductEntity findById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
  }

  @Override
  public ProductEntity findByName(String name) {
    return repository.findByName(name)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
  }

  @Override
  public ProductEntity save(ProductEntity product) {

    if (product == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    return repository.save(product);
  }

  @Override
  public Collection<ProductEntity> saveAll(Collection<ProductEntity> productColl) {

    if (productColl == null || productColl.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    return repository.saveAll(productColl);
  }

  @Override
  public ProductEntity updateById(Long id, ProductEntity product) {

    if (product == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    ProductEntity update = this.findById(id);

    if (product.getName() != null) {
      update.setName(product.getName());
    }

    if (product.getDescription() != null) {
      update.setDescription(product.getDescription());
    }

    if (product.getMeasure() != null) {
      update.setMeasure(product.getMeasure());
    }

    if (product.getQuantity() != null) {
      update.setQuantity(product.getQuantity());
    }

    if (product.getCategory() != null) {
      update.setCategory(product.getCategory());
    }

    return repository.save(update);
  }

  @Override
  public ProductEntity updateByName(String name, ProductEntity product) {

    if (product == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    ProductEntity update = this.findByName(name);

    if (product.getName() != null) {
      update.setName(product.getName());
    }

    if (product.getDescription() != null) {
      update.setDescription(product.getDescription());
    }

    if (product.getMeasure() != null) {
      update.setMeasure(product.getMeasure());
    }

    if (product.getQuantity() != null) {
      update.setQuantity(product.getQuantity());
    }

    if (product.getCategory() != null) {
      update.setCategory(product.getCategory());
    }

    return repository.save(update);
  }

  @Override
  public boolean deleteById(Long id) {

    if (repository.existsById(id)) {
      repository.deleteById(id);
      return true;
    }

    return false;
  }

  @Override
  public boolean deleteByName(String name) {

    if (repository.existsByName(name)) {
      repository.deleteByName(name);
      return true;
    }

    return false;
  }
}