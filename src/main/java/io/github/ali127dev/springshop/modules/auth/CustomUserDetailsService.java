package io.github.ali127dev.springshop.modules.auth;

import io.github.ali127dev.springshop.modules.user.UserService;
import io.github.ali127dev.springshop.modules.user.domain.entity.UserEntity;
import io.github.ali127dev.springshop.shared.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
  private final UserService service;

  @Override
  @NonNull public UserDetails loadUserByUsername(@NonNull String email) throws UsernameNotFoundException {

    UserEntity user;

    try {
      user = service.findByEmail(email);
    } catch (ResourceNotFoundException e) {
      throw new UsernameNotFoundException("User with email %s not found".formatted(email));
    }

    return UserDetailsImpl.from(user);
  }
}
