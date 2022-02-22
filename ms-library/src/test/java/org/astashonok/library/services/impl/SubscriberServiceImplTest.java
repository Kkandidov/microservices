package org.astashonok.library.services.impl;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;
import org.astashonok.library.entities.Subscriber;
import org.astashonok.library.services.SubscriberService;
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
public class SubscriberServiceImplTest {

  @Autowired
  private SubscriberService subscriberService;

  @Test
  public void add() {
    Subscriber expected = Subscriber.builder()
        .name("Pavlov")
        .build();

    subscriberService.add(expected);

    Subscriber actual = subscriberService.getById(expected.getId());
    assertEquals(expected, actual);
  }

  @Test
  public void addAll() {
    Subscriber expected1 = Subscriber.builder()
        .name("Pavlov")
        .build();
    Subscriber expected2 = Subscriber.builder()
        .name("Denisov")
        .build();

    List<Subscriber> expectedSubscribers = List.of(expected1, expected2);
    subscriberService.add(List.of(expected1, expected2));

    Subscriber actual1 = subscriberService.getById(expected1.getId());
    Subscriber actual2 = subscriberService.getById(expected2.getId());
    List<Subscriber> actualSubscribers = List.of(actual1, actual2);

    assertArrayEquals(expectedSubscribers.toArray(), actualSubscribers.toArray());
  }

  @Test
  public void deleteById() {
    Subscriber subscriber = subscriberService.getById(1);
    assertNotNull(subscriber);
    subscriberService.deleteById(1);

    Subscriber actual = subscriberService.getById(1);
    assertNull(actual);
  }

  @Test
  public void delete() {
    Subscriber subscriber = subscriberService.getById(1);
    assertNotNull(subscriber);
    subscriberService.delete(subscriber);

    Subscriber actual = subscriberService.getById(1);
    assertNull(actual);
  }

  @Test
  public void getById() {
    Subscriber expected = Subscriber.builder()
        .name("Petrov P.P.")
        .build();

    Subscriber actual = subscriberService.getById(2);
    assertEquals(expected, actual);
  }

  @Test
  public void edit() {
    Subscriber expected = subscriberService.getById(3);
    expected.setName("Sidorov");
    subscriberService.edit(expected);
    Subscriber actual = subscriberService.getById(3);
    assertEquals(expected, actual);
  }

  @Test
  public void getAll() {
    int expected = 4;
    int actual = subscriberService.getAll().size();
    assertEquals(expected, actual);
  }
}