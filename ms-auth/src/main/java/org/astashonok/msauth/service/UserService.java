package org.astashonok.msauth.service;

import java.util.Optional;
import org.astashonok.msauth.model.entity.User;

public interface UserService {

  Optional<User> findByEmail(String email);
}

