package io.github.ali127dev.springshop.product;

import io.github.ali127dev.springshop.product.dto.CreateProductDTO;
import io.github.ali127dev.springshop.product.dto.UpdateProductDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Products")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
  private final ProductService service;

  @PostMapping("/create")
  public Product create(@Valid @RequestBody CreateProductDTO dto) {
    return service.createProduct(dto);
  }

  @PostMapping("/update")
  public Product update(@Valid @RequestBody UpdateProductDTO dto) {
    return service.updateProduct(dto);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") UUID id) {
    service.deleteProductByID(id);
  }

  @GetMapping
  public List<Product> list() {
    return service.listProducts();
  }

  @GetMapping("/{id}")
  public Product getByID(@PathVariable("id") UUID id) {
    return service.getProductByID(id);
  }
}
