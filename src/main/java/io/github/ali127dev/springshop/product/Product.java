package io.github.ali127dev.springshop.product;

import io.github.ali127dev.springshop.shared.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    private String title;

    @Lob
    private String description;

    @Column(
            nullable = false,
            check = @CheckConstraint(name = "price_positive", constraint = "price >= 0")
    )
    private int price;
}
