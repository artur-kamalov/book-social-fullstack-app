package com.artur.book.book;

import com.artur.book.common.BaseEntity;
import com.artur.book.feedback.Feedback;
import com.artur.book.history.BookTransactionHistory;
import com.artur.book.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book extends BaseEntity {
  private String title;
  private String authorName;
  private String isbn;
  private String synopsis;
  private String bookCover;
  private Boolean archived;
  private Boolean shareable;

  @ManyToOne
  @JoinColumn(name = "owner_id")
  private User owner;

  @OneToMany(mappedBy = "book")
  private List<Feedback> feedbacks;

  @OneToMany(mappedBy = "book")
  private List<BookTransactionHistory> histories;

  @Transient
  public double getRate() {
    if (feedbacks == null || feedbacks.isEmpty()) {
      return 0.0;
    }
    var rate = this.feedbacks.stream()
      .mapToDouble(Feedback::getNote)
      .average()
      .orElse(0.0);

    double roundedRate = Math.round(rate * 10.0) / 10.0;
    // Return 4.0 if roundedRate is less than 4.5, otherwise return 4.5
    return roundedRate;
  }
}
