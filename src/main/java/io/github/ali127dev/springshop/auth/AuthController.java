package io.github.ali127dev.springshop.auth;

import io.github.ali127dev.springshop.user.User;
import io.github.ali127dev.springshop.user.UserRole;
import io.github.ali127dev.springshop.user.UserService;
import io.github.ali127dev.springshop.user.dto.RegisterUser;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Tag(name = "Authentication")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final UserService service;

    @PostMapping("/register")
    public UserResponse register(@RequestBody RegisterUser dto) {
        User saved = service.register(dto);

        return new UserResponse(
                saved.getId(),
                saved.getName(),
                saved.getEmail(),
                saved.getRole()
        );
    }
}

record UserResponse(
        UUID id,
        String name,
        String email,
        UserRole role
) {
}