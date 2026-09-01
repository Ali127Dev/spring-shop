package io.github.ali127dev.springshop.modules.auth.dto;

import io.github.ali127dev.springshop.modules.user.domain.valueobject.UserRole;
import java.util.UUID;

public record UserResponse(UUID id, String name, String email, UserRole role) {}
