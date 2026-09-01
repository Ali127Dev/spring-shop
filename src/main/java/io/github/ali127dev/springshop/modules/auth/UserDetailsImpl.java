package io.github.ali127dev.springshop.modules.auth;

import io.github.ali127dev.springshop.modules.user.domain.entity.UserEntity;
import java.util.Collection;
import java.util.List;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {
  private final UserEntity user;

  private UserDetailsImpl(UserEntity user) {
    this.user = user;
  }

  public static UserDetailsImpl from(UserEntity user) {
    return new UserDetailsImpl(user);
  }

  @Override
  @NonNull public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));
  }

  @Override
  @NonNull public String getPassword() {
    return user.getPassword();
  }

  @Override
  @NonNull public String getUsername() {
    return user.getEmail();
  }
}
