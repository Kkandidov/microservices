package org.astashonok.security.service.impl;

import java.util.Optional;
import org.astashonok.security.model.User;
import org.astashonok.security.repository.UserRepository;
import org.astashonok.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public Optional<User> findByEmail(String email) {
    return userRepository.findByEmail(email);
  }
}
