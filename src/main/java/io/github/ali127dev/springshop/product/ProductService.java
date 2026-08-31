package io.github.ali127dev.springshop.product;

import io.github.ali127dev.springshop.product.dto.CreateProductDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class ProductService {
    private final ProductRepository repository;

    public Product createProduct(CreateProductDTO dto) {
        Product product = new Product();

        product.setTitle(dto.title());
        product.setDescription(dto.description());
        product.setPrice(dto.price());

        return repository.save(product);
    }
}

