package org.astashonok.msauth.model.entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.astashonok.msauth.model.enums.AuthorityName;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "authorities")
public class Authority extends BaseEntity {

  @Enumerated(EnumType.STRING)
  private AuthorityName name;

  @ManyToMany(fetch = FetchType.EAGER, mappedBy = "authorities")
  private Set<Role> roles;
}
