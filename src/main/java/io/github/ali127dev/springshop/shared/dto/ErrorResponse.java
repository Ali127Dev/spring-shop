package io.github.ali127dev.springshop.shared.dto;

public record ErrorResponse(
        String message,
        int status
) {
}