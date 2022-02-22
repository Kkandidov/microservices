package org.astashonok.library.entities.abstracts;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  private long id;

  @Override
  public String toString() {
    return "id='" + id + "'";
  }
}
