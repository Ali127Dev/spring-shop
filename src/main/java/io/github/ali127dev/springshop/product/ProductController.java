package io.github.ali127dev.springshop.product;

import io.github.ali127dev.springshop.product.dto.CreateProductDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService service;

    @PostMapping("/create")
    public Product create(@Valid @RequestBody CreateProductDTO dto) {
        return service.createProduct(dto);
    }

    @GetMapping
    public List<Product> list() {
        return service.listProducts();
    }
}
