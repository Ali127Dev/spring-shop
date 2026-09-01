package io.github.ali127dev.springshop.modules.user.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.ali127dev.springshop.modules.user.domain.valueobject.UserRole;
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
public class UserEntity extends BaseEntity {
  @Column(nullable = false, unique = true)
  String email;

  @Column(nullable = false)
  @JsonIgnore
  String password;

  @Column(nullable = false)
  String name;

  @Enumerated(EnumType.STRING)
  UserRole role = UserRole.USER;
}
