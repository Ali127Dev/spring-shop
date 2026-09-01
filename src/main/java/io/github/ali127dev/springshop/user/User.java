package io.github.ali127dev.springshop.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.ali127dev.springshop.shared.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {
  @Column(nullable = false)
  String email;

  @Column(nullable = false)
  @JsonIgnore
  String password;

  @Column(nullable = false)
  String name;

  @Enumerated(EnumType.STRING)
  UserRole role = UserRole.USER;
}
