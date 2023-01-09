package com.juke.productservice.mapper;

import java.util.Collection;

public interface IBaseMapper<E, D> {

  D toDto(E entity);

  E toEntity(D dto);

  Collection<D> toDtoColl(Collection<E> entityColl);

  Collection<E> toEntityColl(Collection<D> dtoColl);
}