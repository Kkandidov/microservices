package org.astashonok.library.services;

import java.util.List;
import org.astashonok.library.entities.abstracts.AbstractEntity;

public interface CommonEntityService<T extends AbstractEntity> {

  T add(T entity);

  List<T> add(List<T> entities);

  void deleteById(long id);

  void delete(T entity);

  T getById(long id);

  T edit(T entity);

  List<T> getAll();
}
