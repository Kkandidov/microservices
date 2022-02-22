package org.astashonok.library.services.impl;

import org.astashonok.library.entities.Book;
import org.astashonok.library.repositories.BookRepository;
import org.astashonok.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends AbstractCommonEntityService<Book>
    implements BookService {

  @Autowired
  private BookRepository bookRepository;

  @Override
  protected JpaRepository<Book, Long> getRepository() {
    return bookRepository;
  }

}
