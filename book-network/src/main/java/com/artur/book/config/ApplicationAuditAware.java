package com.artur.book.config;

import com.artur.book.user.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class ApplicationAuditAware implements AuditorAware<Integer> {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Override
  public Optional<Integer> getCurrentAuditor() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    if(auth == null || !auth.isAuthenticated() || auth instanceof AnonymousAuthenticationToken) {
      return Optional.empty();
    }

    User userPrincipal = (User) auth.getPrincipal();

    return Optional.ofNullable(userPrincipal.getId());
  }
}
