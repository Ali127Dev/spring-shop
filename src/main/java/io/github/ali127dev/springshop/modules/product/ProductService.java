package io.github.ali127dev.springshop.modules.product;

import io.github.ali127dev.springshop.modules.product.domain.entity.ProductEntity;
import io.github.ali127dev.springshop.modules.product.dto.CreateProductDTO;
import io.github.ali127dev.springshop.modules.product.dto.UpdateProductDTO;
import io.github.ali127dev.springshop.shared.exception.ResourceNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class ProductService {
  private final ProductRepository repository;

  public ProductEntity createProduct(@NonNull CreateProductDTO dto) {
    ProductEntity product = new ProductEntity();

    product.setTitle(dto.title());
    product.setDescription(dto.description());
    product.setPrice(dto.price());

    return repository.save(product);
  }

  public ProductEntity updateProduct(@NonNull UpdateProductDTO dto) {
    ProductEntity product =
        repository
            .findById(dto.id())
            .orElseThrow(() -> new ResourceNotFoundException("Product", dto.id()));

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

  public List<ProductEntity> listProducts() {
    return repository.findAll();
  }

  public ProductEntity getProductByID(UUID id) {
    return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", id));
  }
}
