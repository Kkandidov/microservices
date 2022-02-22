package org.astashonok.library.services.impl;

import org.astashonok.library.entities.Genre;
import org.astashonok.library.repositories.GenreRepository;
import org.astashonok.library.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl extends AbstractCommonEntityService<Genre>
    implements GenreService {

  @Autowired
  private GenreRepository genreRepository;

  @Override
  protected JpaRepository<Genre, Long> getRepository() {
    return genreRepository;
  }

}
