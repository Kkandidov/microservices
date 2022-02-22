package org.astashonok.security.security;

import static org.astashonok.security.model.Status.ACTIVE;

import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.astashonok.security.model.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@RequiredArgsConstructor
public class SecurityUser implements UserDetails {

  private final String username;
  private final String password;
  private final List<SimpleGrantedAuthority> authorities;
  private final boolean enabled;

  @Override
  public boolean isAccountNonExpired() {
    return enabled;
  }

  @Override
  public boolean isAccountNonLocked() {
    return enabled;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return enabled;
  }

  public static UserDetails fromUser(User user) {
    return new org.springframework.security.core.userdetails.User(
        user.getEmail(), user.getPassword(),
        ACTIVE.equals(user.getStatus()),
        ACTIVE.equals(user.getStatus()),
        ACTIVE.equals(user.getStatus()),
        ACTIVE.equals(user.getStatus()),
        user.getRole().getAuthorities()
    );
  }
}
