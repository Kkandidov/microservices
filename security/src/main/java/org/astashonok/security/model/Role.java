package org.astashonok.security.model;

import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@RequiredArgsConstructor
@Getter
public enum Role {
  USER(Set.of(Permission.READ)),
  ADMIN(Set.of(Permission.READ, Permission.WRITE));

  private final Set<Permission> permissions;

  public Set<SimpleGrantedAuthority> getAuthorities() {
    return getPermissions().stream()
        .map(Permission::getPermission)
        .map(SimpleGrantedAuthority::new)
        .collect(Collectors.toSet());
  }
}
