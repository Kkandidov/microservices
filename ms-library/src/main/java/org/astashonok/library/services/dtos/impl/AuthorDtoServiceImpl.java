package org.astashonok.library.services.dtos.impl;

import java.util.List;
import org.astashonok.library.dto.AuthorDto;
import org.astashonok.library.entities.Author;
import org.astashonok.library.mappers.impl.AuthorDtoMapper;
import org.astashonok.library.services.AuthorService;
import org.astashonok.library.services.dtos.AuthorDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorDtoServiceImpl implements AuthorDtoService {

  @Autowired
  private AuthorService authorService;

  @Autowired
  private AuthorDtoMapper authorDtoMapper;

  @Override
  public List<AuthorDto> getAll() {
    List<Author> authors = authorService.getAll();
    return authorDtoMapper.map(authors);
  }
}
