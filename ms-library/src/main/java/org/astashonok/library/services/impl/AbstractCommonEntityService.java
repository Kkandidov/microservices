package org.astashonok.library.services.impl;

import java.util.List;
import javax.annotation.PostConstruct;
import org.astashonok.library.entities.abstracts.AbstractEntity;
import org.astashonok.library.services.CommonEntityService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Transactional
public abstract class AbstractCommonEntityService<T extends AbstractEntity>
    implements CommonEntityService<T> {

  private JpaRepository<T, Long> jpaRepository;

  protected abstract JpaRepository<T, Long> getRepository();

  @PostConstruct
  public void init() {
    jpaRepository = getRepository();
    Assert.notNull(jpaRepository, "No Jpa repository implementation");
  }

  @Override
  public T add(T entity) {
    return jpaRepository.saveAndFlush(entity);
  }

  @Override
  public List<T> add(List<T> entities) {
    return jpaRepository.saveAllAndFlush(entities);
  }

  @Override
  public void deleteById(long id) {
    jpaRepository.deleteById(id);
  }

  @Override
  public void delete(T entity) {
    jpaRepository.delete(entity);
  }

  @Override
  public T getById(long id) {
    return jpaRepository.findById(id).orElse(null);
  }

  @Override
  public T edit(T entity) {
    return jpaRepository.saveAndFlush(entity);
  }

  @Override
  public List<T> getAll() {
    return jpaRepository.findAll();
  }
}
