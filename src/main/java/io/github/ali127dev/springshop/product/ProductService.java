package io.github.ali127dev.springshop.product;

import io.github.ali127dev.springshop.product.dto.CreateProductDTO;
import io.github.ali127dev.springshop.product.dto.UpdateProductDTO;

import java.util.List;
import java.util.UUID;

import io.github.ali127dev.springshop.shared.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class ProductService {
    private final ProductRepository repository;

    public Product createProduct(@NonNull CreateProductDTO dto) {
        Product product = new Product();

        product.setTitle(dto.title());
        product.setDescription(dto.description());
        product.setPrice(dto.price());

        return repository.save(product);
    }

    public Product updateProduct(@NonNull UpdateProductDTO dto) {
        Product product =
                repository.findById(dto.id()).orElseThrow(() -> new ResourceNotFoundException("Product", dto.id()));

        product.setTitle(dto.title());
        product.setDescription(dto.description());
        product.setPrice(dto.price());

        return repository.save(product);
    }

    public void deleteProductByID(UUID id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Product", id);
        }
        repository.deleteById(id);
    }

    public List<Product> listProducts() {
        return repository.findAll();
    }

    public Product getProductByID(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", id));
    }
}
