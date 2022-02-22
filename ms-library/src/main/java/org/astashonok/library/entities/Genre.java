package org.astashonok.library.entities;

import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.astashonok.library.entities.abstracts.AbstractEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "genres")
public class Genre extends AbstractEntity {

  @Column(name = "g_name")
  private String name;

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "genres")
  private Set<Book> books;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Genre)) {
      return false;
    }
    Genre genre = (Genre) o;
    return Objects.equals(name, genre.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return "Genre{" +
        super.toString() +
        ", name='" + name + '\'' +
        '}';
  }
}
