package com.artur.book.handler;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import static org.springframework.http.HttpStatus.*;

public enum BusinessErrorCodes {
  NO_CODE(0, NOT_IMPLEMENTED, "No code"),
  INCORRECT_CURRENT_PASSWORD(300, BAD_REQUEST, "Current password is incorrect"),
  NEW_PASSWORD_DOES_NOT_MATCH(301, BAD_REQUEST, "New password does not match"),
  ACCOUNT_LOCKED(302, FORBIDDEN, "Account locked"),
  ACCOUNT_DISABLED(303, FORBIDDEN, "Account is disabled"),
  BAD_CREDENTIALS(304, FORBIDDEN, "Login and / or password is incorrect"),
  ;

  @Getter
  private final int code;
  @Getter
  private final String description;
  @Getter
  private final HttpStatus httpStatus;

  BusinessErrorCodes(
    int code,
    HttpStatus httpStatus,
    String description
  ) {
    this.code = code;
    this.httpStatus = httpStatus;
    this.description = description;
  }
}
