package io.github.ali127dev.springshop.product.exception;

import io.github.ali127dev.springshop.shared.exception.AppException;

import java.util.UUID;

public class ProductNotFoundException extends AppException {
    public ProductNotFoundException(UUID id) {
        super("Product with id " + id + " not found");
    }
}
