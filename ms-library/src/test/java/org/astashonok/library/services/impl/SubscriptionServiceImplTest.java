package org.astashonok.library.services.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import org.astashonok.library.entities.Book;
import org.astashonok.library.entities.Subscriber;
import org.astashonok.library.entities.Subscription;
import org.astashonok.library.entities.enums.Active;
import org.astashonok.library.services.SubscriptionService;
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
public class SubscriptionServiceImplTest {

  @Autowired
  private SubscriptionService subscriptionService;

  @Test
  public void add() {
    Book book = Book.builder()
        .name("Bread with ham")
        .year(2005)
        .quantity(5)
        .build();

    Subscriber subscriber = Subscriber.builder()
        .name("Pavlov")
        .build();

    Subscription subscription = Subscription.builder()
        .subscriber(subscriber)
        .book(book)
        .start(new Date())
        .finish(new Date())
        .active(Active.Y)
        .build();

    subscriptionService.add(subscription);

    int expected = 12;
    int actual = subscriptionService.getAll().size();
    assertEquals(expected, actual);
  }

  @Test
  public void deleteById() {
    Subscription subscription = subscriptionService.getById(100);
    assertNotNull(subscription);
    subscriptionService.deleteById(100);

    Subscription actual = subscriptionService.getById(100);
    assertNull(actual);
  }

  @Test
  public void delete() {
    Subscription subscription = subscriptionService.getById(100);
    assertNotNull(subscription);
    subscriptionService.delete(subscription);

    Subscription actual = subscriptionService.getById(100);
    assertNull(actual);
  }

  @Test
  public void getById() {
    Subscription actual = subscriptionService.getById(3);
    assertNotNull(actual);
  }

  @Test
  public void edit() {
    Subscription expected = subscriptionService.getById(61);
    expected.setActive(Active.Y);
    subscriptionService.edit(expected);
    Subscription actual = subscriptionService.getById(61);
    assertEquals(expected, actual);
  }

  @Test
  public void getAll() {
    int expected = 11;
    int actual = subscriptionService.getAll().size();
    assertEquals(expected, actual);
  }
}