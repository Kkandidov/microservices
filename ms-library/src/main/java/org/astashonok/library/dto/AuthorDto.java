package org.astashonok.library.dto;

import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorDto {

  private String name;
  private Set<BookDto> books;
}
