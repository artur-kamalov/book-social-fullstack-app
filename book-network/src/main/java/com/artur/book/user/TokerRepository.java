package com.artur.book.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokerRepository extends JpaRepository<Token, Integer> {
    Optional<Token> findByToken(String token);
}
