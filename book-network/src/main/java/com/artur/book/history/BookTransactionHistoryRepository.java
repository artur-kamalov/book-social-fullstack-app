package com.artur.book.history;

import com.artur.book.book.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.lang.ScopedValue;
import java.util.Optional;

public interface BookTransactionHistoryRepository extends JpaRepository<BookTransactionHistory, Integer> {

  @Query("""
          select history
          from BookTransactionHistory history
          where history.user.id = :userId
        """)
  Page<BookTransactionHistory> findAllBorrowedBooks(
    Pageable pageable,
    Integer userId
  );

  @Query("""
          select history
          from BookTransactionHistory history
          where history.book.owner.id = :userId
        """)
  Page<BookTransactionHistory> findAllReturnedBooks(
    Pageable pageable,
    Integer userId
  );

  @Query("""
          select
          (count(*) > 0) as isBorrowed
          from BookTransactionHistory history
          where history.user.id = :userId
          and history.book.id = :bookId
          and history.returnApproved = false
        """)
  boolean isAlreadyBorrowedByUser(
    Integer bookId,
    Integer userId
  );

  @Query("""
          select transaction
          from BookTransactionHistory transaction
          where transaction.user.id = :userId
          and transaction.book.id = :bookId
          and transaction.returned = false
          and transaction.returnApproved = false
        """)
  Optional<BookTransactionHistory> findByBookIdAndUserId(
    Integer bookId,
    Integer userId
  );

  @Query("""
          select transaction
          from BookTransactionHistory transaction
          where transaction.book.owner.id = :userId
          and transaction.book.id = :bookId
          and transaction.returned = true
          and transaction.returnApproved = false
        """)
  Optional<BookTransactionHistory> findByBookIdAndOwnerId(
    Integer bookId,
    Integer userId
  );
}
