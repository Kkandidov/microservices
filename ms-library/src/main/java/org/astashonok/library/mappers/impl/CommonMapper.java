package org.astashonok.library.mappers.impl;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.astashonok.library.mappers.Mapper;

public abstract class CommonMapper<T, R> implements Mapper<T, R> {

  @Override
  public R map(T object) {
    return Optional.ofNullable(object)
        .map(this::mapObject)
        .orElse(null);
  }

  @Override
  public List<R> map(List<T> objects) {
    return CollectionUtils.isEmpty(objects)
        ? Collections.emptyList()
        : objects.stream()
            .filter(Objects::nonNull)
            .map(this::map)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
  }

  protected abstract R mapObject(T object);
}
