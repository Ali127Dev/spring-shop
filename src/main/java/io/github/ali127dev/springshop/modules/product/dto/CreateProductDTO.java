package io.github.ali127dev.springshop.modules.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateProductDTO(
        @NotBlank @Size(min = 3) @Schema(example = "MacBook Pro") String title,
        @Schema(example = "the best laptop you've ever seen") String description,
        @NotNull @Min(0) @Schema(example = "2400") Integer price) {
}
