package org.astashonok.msauth.model.entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.astashonok.msauth.model.enums.RoleName;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "roles")
public class Role extends BaseEntity {

  @Enumerated(EnumType.STRING)
  private RoleName name;

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
  private Set<User> users;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "roles_authorities",
      joinColumns = @JoinColumn(name = "role_id"),
      inverseJoinColumns = @JoinColumn(name = "authority_id"))
  private Set<Authority> authorities;
}
