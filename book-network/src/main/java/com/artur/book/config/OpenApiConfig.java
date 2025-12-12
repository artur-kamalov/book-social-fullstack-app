package com.artur.book.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
  info = @Info(
    contact = @Contact(
      name = "Artur",
      email = "camalov.arthur@gmail.com"
    ),
    description = "OpenApi documentation for Spring security",
    title = "OpenApi specification",
    version = "1.0"
  ),
  servers = {
    @Server(
      description = "Local ENV",
      url = "http://localhodst:8088/api/v1"
    ),
    @Server(
      description = "Prod ENV",
      url = "https://someProdUrl.com"
    )
  },
  security = {
    @SecurityRequirement(
      name = "bearerAuth"
    )
  }
)
@SecurityScheme(
  name = "bearerAuth",
  description = "JWT auth desc",
  scheme = "bearer",
  type = SecuritySchemeType.HTTP,
  bearerFormat = "JWT",
  in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}
