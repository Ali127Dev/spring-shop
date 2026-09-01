package io.github.ali127dev.springshop.modules.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterUser(
        @NotBlank @Email @Schema(example = "ali127dev@gmail.com") String email,
        @NotBlank @Size(min = 8) @Schema(example = "strongpass") String password,
        @NotBlank @Size(min = 3) @Schema(example = "Ali Moradi") String name) {
}
