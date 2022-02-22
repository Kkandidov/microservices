package org.astashonok.msauth.service.impl;

import java.util.Optional;
import org.astashonok.msauth.model.entity.User;
import org.astashonok.msauth.repository.UserRepository;
import org.astashonok.msauth.service.UserService;
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
