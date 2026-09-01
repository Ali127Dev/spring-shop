package io.github.ali127dev.springshop.user;

import io.github.ali127dev.springshop.auth.dto.UserResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Users")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
  private final UserService service;

  @GetMapping("/me")
  public UserResponse me(Authentication authentication) {
    User user = service.findByEmail(authentication.getName());

    return new UserResponse(user.getId(), user.getName(), user.getEmail(), user.getRole());
  }
}
