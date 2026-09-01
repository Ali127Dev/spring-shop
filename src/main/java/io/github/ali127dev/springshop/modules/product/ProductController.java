package io.github.ali127dev.springshop.modules.product;

import io.github.ali127dev.springshop.modules.product.domain.entity.ProductEntity;
import io.github.ali127dev.springshop.modules.product.dto.CreateProductDTO;
import io.github.ali127dev.springshop.modules.product.dto.UpdateProductDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Products")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
  private final ProductService service;

  @PostMapping("/create")
  @PreAuthorize("hasRole('ADMIN')")
  public ProductEntity create(@Valid @RequestBody CreateProductDTO dto) {
    return service.createProduct(dto);
  }

  @PostMapping("/update")
  @PreAuthorize("hasRole('ADMIN')")
  public ProductEntity update(@Valid @RequestBody UpdateProductDTO dto) {
    return service.updateProduct(dto);
  }

  @DeleteMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public void delete(@PathVariable("id") UUID id) {
    service.deleteProductByID(id);
  }

  @GetMapping
  @SecurityRequirements()
  public List<ProductEntity> list() {
    return service.listProducts();
  }

  @GetMapping("/{id}")
  @SecurityRequirements()
  public ProductEntity getByID(@PathVariable("id") UUID id) {
    return service.getProductByID(id);
  }
}
