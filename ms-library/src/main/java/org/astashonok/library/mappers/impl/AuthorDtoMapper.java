package org.astashonok.library.mappers.impl;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.astashonok.library.dto.AuthorDto;
import org.astashonok.library.dto.BookDto;
import org.astashonok.library.entities.Author;
import org.astashonok.library.entities.Book;
import org.springframework.stereotype.Component;

@Component
public class AuthorDtoMapper extends CommonMapper<Author, AuthorDto> {

  @Override
  protected AuthorDto mapObject(Author author) {
    return AuthorDto.builder()
        .name(author.getName())
        .books(createBookDtos(author.getBooks()))
        .build();
  }

  private Set<BookDto> createBookDtos(Set<Book> books) {
    return CollectionUtils.isEmpty(books)
        ? Collections.emptySet()
        : books.stream()
            .filter(Objects::nonNull)
            .map(book -> BookDto.builder()
                .name(book.getName())
                .year(book.getYear())
                .quantity(book.getQuantity())
                .build())
            .collect(Collectors.toSet());
  }
}
