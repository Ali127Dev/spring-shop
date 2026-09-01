package io.github.ali127dev.springshop.auth.dto;

import io.github.ali127dev.springshop.user.UserRole;
import java.util.UUID;

public record UserResponse(UUID id, String name, String email, UserRole role) {}
