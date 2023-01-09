package com.juke.productservice.controller;

import com.juke.productservice.dto.ProductDto;
import com.juke.productservice.entity.ProductEntity;
import com.juke.productservice.mapper.ProductMapper;
import com.juke.productservice.service.IProductService;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("api/v1/product")
@RestController
public class ProductController {

  private final IProductService service;
  private final ProductMapper mapper;

  @GetMapping
  public ResponseEntity<Collection<ProductDto>> findAll() {
    Collection<ProductEntity> entityColl = service.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(mapper.toDtoColl(entityColl));
  }

  @GetMapping("/category/{category}")
  public ResponseEntity<Collection<ProductDto>> findAllByCategory(@PathVariable String category) {
    Collection<ProductEntity> entityColl = service.findAllByCategory(category);
    return ResponseEntity.status(HttpStatus.OK).body(mapper.toDtoColl(entityColl));
  }

  @GetMapping("/id/{id}")
  public ResponseEntity<ProductDto> findById(@PathVariable Long id) {
    ProductEntity entity = service.findById(id);
    return ResponseEntity.status(HttpStatus.OK).body(mapper.toDto(entity));
  }

  @GetMapping("/name/{name}")
  public ResponseEntity<ProductDto> findByName(@PathVariable String name) {
    ProductEntity entity = service.findByName(name);
    return ResponseEntity.status(HttpStatus.OK).body(mapper.toDto(entity));
  }

  @PostMapping
  public ResponseEntity<ProductDto> save(@RequestBody ProductDto dto) {
    ProductEntity entity = service.save(mapper.toEntity(dto));
    return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(entity));
  }

  @PostMapping("/all")
  public ResponseEntity<Collection<ProductDto>> saveAll(
      @RequestBody Collection<ProductDto> dtoColl
  ) {
    Collection<ProductEntity> entityColl = service.saveAll(mapper.toEntityColl(dtoColl));
    return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDtoColl(entityColl));
  }

  @PutMapping("/id/{id}")
  public ResponseEntity<ProductDto> updateById(
      @PathVariable Long id,
      @RequestBody ProductDto dto
  ) {
    ProductEntity entity = service.updateById(id, mapper.toEntity(dto));
    return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(entity));
  }

  @PutMapping("/name/{name}")
  public ResponseEntity<ProductDto> updateByName(
      @PathVariable String name,
      @RequestBody ProductDto dto
  ) {
    ProductEntity entity = service.updateByName(name, mapper.toEntity(dto));
    return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(entity));
  }

  @DeleteMapping("/id/{id}")
  public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.deleteById(id));
  }

  @DeleteMapping("/name/{name}")
  public ResponseEntity<Boolean> deleteByName(@PathVariable String name) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.deleteByName(name));
  }
}