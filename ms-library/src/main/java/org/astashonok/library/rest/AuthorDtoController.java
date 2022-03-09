package org.astashonok.library.rest;

import java.util.List;
import org.astashonok.library.dto.AuthorDto;
import org.astashonok.library.services.dtos.AuthorDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorDtoController {

  @Autowired
  private AuthorDtoService authorDtoService;

  @GetMapping("/authors")
  public ResponseEntity<List<AuthorDto>> getAll() {
    return ResponseEntity.ok(authorDtoService.getAll());
  }
}
