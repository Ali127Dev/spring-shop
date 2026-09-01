package io.github.ali127dev.springshop.modules.product;

import io.github.ali127dev.springshop.modules.product.domain.entity.ProductEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {}
