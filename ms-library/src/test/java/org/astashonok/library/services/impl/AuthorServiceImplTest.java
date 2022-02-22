package org.astashonok.library.services.impl;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;
import org.astashonok.library.entities.Author;
import org.astashonok.library.services.AuthorService;
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
public class AuthorServiceImplTest {

  @Autowired
  private AuthorService authorService;

  @Test
  public void add() {
    Author expected = new Author();
    expected.setName("Dostoevsky");
    authorService.add(expected);

    Author actual = authorService.getById(expected.getId());
    assertEquals(expected, actual);
  }

  @Test
  public void addAll() {
    Author expected1 = new Author();
    expected1.setName("Dostoevsky");
    Author expected2 = new Author();
    expected2.setName("Bukovsky");

    List<Author> expectedAuthors = List.of(expected1, expected2);
    authorService.add(List.of(expected1, expected2));

    Author actual1 = authorService.getById(expected1.getId());
    Author actual2 = authorService.getById(expected2.getId());
    List<Author> actualAuthors = List.of(actual1, actual2);

    assertArrayEquals(expectedAuthors.toArray(), actualAuthors.toArray());
  }

  @Test
  public void deleteById() {
    Author author = authorService.getById(1);
    assertNotNull(author);
    authorService.deleteById(1);

    Author actual = authorService.getById(1);
    assertNull(actual);
  }

  @Test
  public void delete() {
    Author author = authorService.getById(1);
    assertNotNull(author);
    authorService.delete(author);

    Author actual = authorService.getById(1);
    assertNull(actual);
  }

  @Test
  public void getById() {
    Author expected = new Author();
    expected.setName("L.D. Landau");

    Author actual = authorService.getById(4);
    assertEquals(expected, actual);
  }

  @Test
  public void edit() {
    Author expected = authorService.getById(4);
    expected.setName("L.D. Landava");
    authorService.edit(expected);
    Author actual = authorService.getById(4);
    assertEquals(expected, actual);
  }

  @Test
  public void getAll() {
    int expected = 7;
    int actual = authorService.getAll().size();
    assertEquals(expected, actual);
  }
}