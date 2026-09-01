package io.github.ali127dev.springshop.auth;

import io.github.ali127dev.springshop.auth.dto.AuthResponse;
import io.github.ali127dev.springshop.auth.dto.LoginRequest;
import io.github.ali127dev.springshop.user.dto.RegisterUser;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Authentication")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
@SecurityRequirements()
public class AuthController {
  private final AuthService authService;

  @PostMapping("/register")
  public AuthResponse register(@Valid @RequestBody RegisterUser dto) {
    String token = authService.register(dto);

    return new AuthResponse(token);
  }

  @PostMapping("/login")
  public AuthResponse login(@Valid @RequestBody LoginRequest dto) {
    String token = authService.login(dto);
    return new AuthResponse(token);
  }
}
