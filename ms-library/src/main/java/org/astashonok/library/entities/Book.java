package org.astashonok.library.entities;

import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.astashonok.library.entities.abstracts.AbstractEntity;
import org.astashonok.library.utils.CommonUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "books")
public class Book extends AbstractEntity {

  @Column(name = "b_name")
  private String name;

  @Column(name = "b_year")
  private int year;

  @Column(name = "b_quantity")
  private int quantity;

  @ManyToMany(fetch = FetchType.EAGER, mappedBy = "books")
  private Set<Author> authors;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "m2m_books_genres",
      joinColumns = @JoinColumn(name = "b_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "g_id", referencedColumnName = "id"))
  private Set<Genre> genres;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
  private Set<Subscription> subscriptions;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Book)) {
      return false;
    }
    Book book = (Book) o;
    return Objects.equals(year, book.getYear())
        && Objects.equals(quantity, book.getQuantity())
        && Objects.equals(name, book.getName())
        && CommonUtils.equalsIgnoreEmptyAndNull(genres, book.getGenres())
        && CommonUtils.equalsIgnoreEmptyAndNull(authors, book.getAuthors());
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, year, quantity, genres, authors);
  }

  @Override
  public String toString() {
    return "Book{" +
        super.toString() +
        ", name='" + name + '\'' +
        ", year=" + year +
        ", quantity=" + quantity +
        '}';
  }
}
