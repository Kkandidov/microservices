package org.astashonok.security.rest;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @GetMapping("/users")
  private List<String> getAll() {
    return Arrays.asList(
        "DDDDDDDDDDDDDDDDDDDDD",
        "RRRRRRRRRRRRRRRRRRRRRR",
        "FFFFFFFFFFFFFFFFFFFFFF"
    );
  }

  @GetMapping("/")
  public String hello() {
    return "Hello";
  }

  @GetMapping("/auth")
  public String authHello() {
    return "Auth Hello";
  }
}
