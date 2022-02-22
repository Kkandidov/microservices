package org.astashonok.library.services.impl;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.Set;
import org.astashonok.library.entities.Author;
import org.astashonok.library.entities.Book;
import org.astashonok.library.entities.Genre;
import org.astashonok.library.services.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(scripts = {"/create.sql", "/populate.sql"},
    executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class BookServiceImplTest {

  @Autowired
  private BookService bookService;

  @Test
  public void add() {
    Book expected = Book.builder()
        .name("Bread with ham")
        .year(2005)
        .quantity(5)
        .build();

    bookService.add(expected);

    Book actual = bookService.getById(expected.getId());
    assertEquals(expected, actual);
  }

  @Test
  public void addAll() {
    Book expected1 = Book.builder()
        .name("Bread with ham")
        .year(2005)
        .quantity(5)
        .build();
    Book expected2 = Book.builder()
        .name("Crime and Punishment")
        .year(2005)
        .quantity(5)
        .build();

    List<Book> expectedBooks = List.of(expected1, expected2);
    bookService.add(List.of(expected1, expected2));

    Book actual1 = bookService.getById(expected1.getId());
    Book actual2 = bookService.getById(expected2.getId());
    List<Book> actualBooks = List.of(actual1, actual2);

    assertArrayEquals(expectedBooks.toArray(), actualBooks.toArray());
  }

  @Test
  public void deleteById() {
    Book book = bookService.getById(1);
    assertNotNull(book);
    bookService.deleteById(1);

    Book actual = bookService.getById(1);
    assertNull(actual);
  }

  @Test
  public void delete() {
    Book book = bookService.getById(1);
    assertNotNull(book);
    bookService.delete(book);

    Book actual = bookService.getById(1);
    assertNull(actual);
  }

  @Test
  public void getById() {
    Book expected = Book.builder()
        .name("C++ programming language")
        .year(1996)
        .quantity(3)
        .genres(Set.of(Genre.builder().name("Programming").build()))
        .authors(Set.of(Author.builder().name("B. Stroustrup").build()))
        .build();

    Book actual = bookService.getById(5);
    assertEquals(expected, actual);
  }

  @Test
  public void edit() {
    Book expected = bookService.getById(4);
    expected.setName("Landava");
    bookService.edit(expected);
    Book actual = bookService.getById(4);
    assertEquals(expected, actual);
  }

  @Test
  public void getAll() {
    int expected = 7;
    int actual = bookService.getAll().size();
    assertEquals(expected, actual);
  }
}