package io.github.ali127dev.springshop.modules.health;

import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Health")
@RestController
@SecurityRequirements()
public class HealthController {

  @GetMapping("/health")
  public String health() {
    return "ok";
  }
}
