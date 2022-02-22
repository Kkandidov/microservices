package org.astashonok.library.entities;

import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "authors")
public class Author extends AbstractEntity {

  @Column(name = "a_name")
  private String name;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "m2m_books_authors",
      joinColumns = @JoinColumn(name = "a_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "b_id", referencedColumnName = "id"))
  private Set<Book> books;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Author)) {
      return false;
    }
    Author author = (Author) o;
    return Objects.equals(name, author.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return "Author{" +
        super.toString() +
        ", name='" + name + '\'' +
        '}';
  }
}
