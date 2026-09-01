package io.github.ali127dev.springshop.auth;

import io.github.ali127dev.springshop.auth.dto.LoginRequest;
import io.github.ali127dev.springshop.user.User;
import io.github.ali127dev.springshop.user.UserService;
import io.github.ali127dev.springshop.user.dto.RegisterUser;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
  private final AuthenticationManager authenticationManager;
  private final JwtService jwtService;
  private final UserService userService;

  public String login(LoginRequest dto) {
    Authentication authentication =
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(dto.email(), dto.password()));

    return jwtService.generateToken(
        (UserDetails) Objects.requireNonNull(authentication.getPrincipal()));
  }

  public String register(RegisterUser dto) {
    User registeredUser = userService.register(dto);

    UserDetails userDetails = UserDetailsImpl.from(registeredUser);

    return jwtService.generateToken(userDetails);
  }
}
