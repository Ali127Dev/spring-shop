package io.github.ali127dev.springshop.modules.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(
    @NotBlank @Email @Schema(example = "ali127dev@gmail.com") String email,
    @NotBlank @Size(min = 8) @Schema(example = "strongpass") String password) {}
