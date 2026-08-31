package io.github.ali127dev.springshop.product;

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
public class ProductEntity {

    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
    private UUID id;

    private String title;

    @Lob
    private String description;

    @Column(
            nullable = false,
            check = @CheckConstraint(name = "price_positive", constraint = "price >= 0")
    )
    private int price;
}
