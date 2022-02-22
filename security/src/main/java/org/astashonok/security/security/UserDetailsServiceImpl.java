package org.astashonok.security.security;

import org.astashonok.security.model.User;
import org.astashonok.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(UserDetailsServiceImpl.NAME)
public class UserDetailsServiceImpl implements UserDetailsService {

  public static final String NAME = "userDetailsServiceImpl";

  private static final String USER_NOT_EXISTS = "User doesn't exist";

  @Autowired
  private UserService userService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userService.findByEmail(username)
        .orElseThrow(() -> new UsernameNotFoundException(USER_NOT_EXISTS));

    return SecurityUser.fromUser(user);
  }
}
