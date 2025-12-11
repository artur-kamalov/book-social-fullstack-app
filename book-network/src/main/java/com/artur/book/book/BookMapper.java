package com.artur.book.book;

import com.artur.book.file.FileUtils;
import com.artur.book.history.BookTransactionHistory;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {
  public Book toBook(BookRequest request) {
    return Book
      .builder()
      .id(request.id())
      .title(request.title())
      .isbn(request.isbn())
      .authorName(request.authorName())
      .synopsis(request.synopsis())
      .archived(false)
      .shareable(request.shareable())
      .build();
  }


  public BookResponse toBookResponse(@NotNull Book book) {
    return BookResponse
      .builder()
      .id(book.getId())
      .title(book.getTitle())
      .authorName(book.getAuthorName())
      .isbn(book.getIsbn())
      .synopsis(book.getSynopsis())
      .owner(book
        .getOwner()
        .fullName())
      .rate(book.getRate())
      .archived(book.getArchived())
      .shareable(book.getShareable())
      .cover(FileUtils.readFileFromLocation(book.getBookCover()))
      .build();
  }

  public BorrowedBookResponse toBorrowedBookResponse(BookTransactionHistory transactionHistory) {
    return BorrowedBookResponse
      .builder()
      .id(transactionHistory
        .getBook()
        .getId())
      .title(transactionHistory
        .getBook()
        .getTitle())
      .authorName(transactionHistory
        .getBook()
        .getAuthorName())
      .isbn(transactionHistory
        .getBook()
        .getIsbn())
      .rate(transactionHistory
        .getBook()
        .getRate())
      .returned(transactionHistory.isReturned())
      .returnApproved(transactionHistory.isReturnApproved())
      .build();
  }

  //  public BorrowedBookResponse toBorrowedBookResponse(BookTransactionHistory history) {
  //    return BorrowedBookResponse.builder()
  //      .id(history.getBook().getId())
  //      .title(history.getBook().getTitle())
  //      .authorName(history.getBook().getAuthorName())
  //      .isbn(history.getBook().getIsbn())
  //      .rate(history.getBook().getRate())
  //      .returned(history.isReturned())
  //      .returnApproved(history.isReturnApproved())
  //      .build();
  //  }
}
