package org.astashonok.library.services.impl;

import org.astashonok.library.entities.Author;
import org.astashonok.library.repositories.AuthorRepository;
import org.astashonok.library.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl extends AbstractCommonEntityService<Author>
    implements AuthorService {

  @Autowired
  private AuthorRepository authorRepository;

  @Override
  protected JpaRepository<Author, Long> getRepository() {
    return authorRepository;
  }
}
