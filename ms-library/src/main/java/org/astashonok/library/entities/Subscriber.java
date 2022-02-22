package org.astashonok.library.entities;

import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
@Table(name = "subscribers")
public class Subscriber extends AbstractEntity {

  @Column(name = "s_name")
  private String name;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "subscriber")
  private Set<Subscription> subscriptions;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Subscriber)) {
      return false;
    }
    Subscriber subscriber = (Subscriber) o;
    return Objects.equals(name, subscriber.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return "Subscriber{" +
        super.toString() +
        ", name='" + name + '\'' +
        '}';
  }
}
