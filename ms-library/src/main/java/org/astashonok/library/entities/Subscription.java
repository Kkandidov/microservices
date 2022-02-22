package org.astashonok.library.entities;

import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.astashonok.library.entities.abstracts.AbstractEntity;
import org.astashonok.library.entities.enums.Active;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "subscriptions")
public class Subscription extends AbstractEntity {

  @ManyToOne(fetch = FetchType.EAGER, cascade = {MERGE, PERSIST, REFRESH, DETACH})
  @JoinColumn(name = "sb_subscriber", nullable = false)
  private Subscriber subscriber;

  @ManyToOne(fetch = FetchType.EAGER, cascade = {MERGE, PERSIST, REFRESH, DETACH})
  @JoinColumn(name = "sb_book", nullable = false)
  private Book book;

  @Column(name = "sb_start")
  @Temporal(TemporalType.TIMESTAMP)
  private Date start;

  @Column(name = "sb_finish")
  @Temporal(TemporalType.TIMESTAMP)
  private Date finish;

  @Column(name = "sb_is_active")
  @Enumerated(EnumType.STRING)
  private Active active;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Subscription)) {
      return false;
    }
    Subscription subscription = (Subscription) o;
    return Objects.equals(subscriber, subscription.getSubscriber())
        && Objects.equals(book, subscription.getBook())
        && Objects.equals(start, subscription.getStart())
        && Objects.equals(finish, subscription.getFinish())
        && Objects.equals(active, subscription.getActive());
  }

  @Override
  public int hashCode() {
    return Objects.hash(subscriber, book, start, finish, active);
  }

  @Override
  public String toString() {
    return "Subscription{" +
        super.toString() +
        ", subscriber=" + subscriber +
        ", book=" + book +
        ", start=" + start +
        ", finish=" + finish +
        ", active=" + active +
        '}';
  }
}
