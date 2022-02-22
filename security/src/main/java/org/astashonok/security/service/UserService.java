package org.astashonok.security.service;

import java.util.Optional;
import org.astashonok.security.model.User;

public interface UserService {

  Optional<User> findByEmail(String email);
}
