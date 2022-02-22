package org.astashonok.msauth.service;

import java.util.Optional;
import org.astashonok.msauth.model.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

  @Autowired
  private UserService userService;

  @Test
  void findByEmail() {
    Optional<User> ewe = userService.findByEmail("ewe");

    System.out.println("wewewewe");
  }
}