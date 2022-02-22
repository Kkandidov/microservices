package org.astashonok.library.services.impl;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import org.astashonok.library.entities.Genre;
import org.astashonok.library.services.GenreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(scripts = {"/create.sql", "/populate.sql"},
    executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class GenreServiceImplTest {

  @Autowired
  private GenreService genreService;

  @Test
  public void add() {
    Genre expected = Genre.builder()
        .name("Non Fiction")
        .build();

    genreService.add(expected);

    Genre actual = genreService.getById(expected.getId());
    assertEquals(expected, actual);
  }

  @Test
  public void addAll() {
    Genre expected1 = Genre.builder()
        .name("Non Fiction")
        .build();
    Genre expected2 = Genre.builder()
        .name("Mathematic")
        .build();

    List<Genre> expectedGenres = List.of(expected1, expected2);
    genreService.add(List.of(expected1, expected2));

    Genre actual1 = genreService.getById(expected1.getId());
    Genre actual2 = genreService.getById(expected2.getId());
    List<Genre> actualGenres = List.of(actual1, actual2);

    assertArrayEquals(expectedGenres.toArray(), actualGenres.toArray());
  }

  @Test(expected = DataIntegrityViolationException.class)
  public void deleteById() {
    Genre genre = genreService.getById(1);
    assertNotNull(genre);
    genreService.deleteById(1);
  }

  @Test(expected = DataIntegrityViolationException.class)
  public void delete() {
    Genre genre = genreService.getById(1);
    assertNotNull(genre);
    genreService.delete(genre);
  }

  @Test
  public void getById() {
    Genre expected = Genre.builder()
        .name("The science")
        .build();

    Genre actual = genreService.getById(4);
    assertEquals(expected, actual);
  }

  @Test
  public void edit() {
    Genre expected = genreService.getById(3);
    expected.setName("Psychology 3");
    genreService.edit(expected);
    Genre actual = genreService.getById(3);
    assertEquals(expected, actual);
  }

  @Test
  public void getAll() {
    int expected = 6;
    int actual = genreService.getAll().size();
    assertEquals(expected, actual);
  }
}