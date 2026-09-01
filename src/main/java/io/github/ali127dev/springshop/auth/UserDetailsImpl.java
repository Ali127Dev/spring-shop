package io.github.ali127dev.springshop.auth;

import io.github.ali127dev.springshop.user.User;
import java.util.Collection;
import java.util.List;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {
  private final User user;

  private UserDetailsImpl(User user) {
    this.user = user;
  }

  public static UserDetailsImpl from(User user) {
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
