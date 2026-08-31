package io.github.ali127dev.springshop.product;

import io.github.ali127dev.springshop.product.dto.CreateProductDTO;
import io.github.ali127dev.springshop.product.dto.UpdateProductDTO;
import io.github.ali127dev.springshop.product.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public Product updateProduct(UpdateProductDTO dto) {
        Product product = repository.findById(dto.id())
                .orElseThrow(() -> new ProductNotFoundException(dto.id()));

        product.setTitle(dto.title());
        product.setDescription(dto.description());
        product.setPrice(dto.price());

        return repository.save(product);
    }

    public void deleteProductByID(UUID id) {
        if (!repository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        repository.deleteById(id);
    }

    public List<Product> listProducts() {
        return repository.findAll();
    }

    public Product getProductByID(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }
}

