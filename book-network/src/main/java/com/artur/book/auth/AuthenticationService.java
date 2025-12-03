package com.artur.book.auth;

import com.artur.book.role.RoleRepository;
import com.artur.book.user.User;
import com.artur.book.user.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final RoleRepository roleRepository;
  private final PasswordEncoder passwordEncoder;
  private final UserRepository userRepository;

  public void register(@Valid RegistrationRequest req) { // Todo @Valid annotation
    var userRole = roleRepository.findByName("USER") // todo improve exception handling
      .orElseThrow(() -> new IllegalStateException("Role User not found"));

    var user = User.builder()
      .firstname(req.getFirstname())
      .lastname(req.getLastname())
      .email(req.getEmail())
      .password(passwordEncoder.encode(req.getPassword()))
      .accountLocked(false)
      .enabled(false)
      .roles(List.of(userRole))
      .build();

    userRepository.save(user);
    sendValidationEmail(user);
  }

  private void sendValidationEmail(User user) {
    var newToken = generateAndSaveActivationToken(user);
    // todo send email
  }

  private Object generateAndSaveActivationToken(User user) {
    return null;
  }
}
