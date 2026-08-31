package io.github.ali127dev.springshop.product.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UpdateProductDTO(
        @org.hibernate.validator.constraints.UUID
        UUID id,

        @NotBlank
        String title,

        String description,

        @NotNull
        @Min(0)
        int price
) {
}
