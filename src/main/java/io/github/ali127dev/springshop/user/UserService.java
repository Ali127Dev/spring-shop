package io.github.ali127dev.springshop.user;

import io.github.ali127dev.springshop.user.dto.RegisterUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;

  public User register(RegisterUser dto) {
    User user = new User();
    user.setName(dto.name());
    user.setEmail(dto.email());
    user.setPassword(passwordEncoder.encode(dto.password()));
    user.setRole(UserRole.USER);

    return repository.save(user);
  }
}
