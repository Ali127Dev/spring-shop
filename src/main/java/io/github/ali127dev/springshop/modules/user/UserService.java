package io.github.ali127dev.springshop.modules.user;

import io.github.ali127dev.springshop.modules.user.domain.entity.UserEntity;
import io.github.ali127dev.springshop.modules.user.domain.valueobject.UserRole;
import io.github.ali127dev.springshop.modules.user.dto.RegisterUser;
import io.github.ali127dev.springshop.shared.exception.ResourceAlreadyExistsException;
import io.github.ali127dev.springshop.shared.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;

  public UserEntity register(RegisterUser dto) {
    if (repository.existsByEmail(dto.email())) {
      throw new ResourceAlreadyExistsException("User", dto.email());
    }

    UserEntity user = new UserEntity();
    user.setName(dto.name());
    user.setEmail(dto.email());
    user.setPassword(passwordEncoder.encode(dto.password()));
    user.setRole(UserRole.USER);

    return repository.save(user);
  }

  public UserEntity findByEmail(String email) {
    return repository
        .findByEmail(email)
        .orElseThrow(() -> new ResourceNotFoundException("User", email));
  }
}
