package io.github.ali127dev.springshop.shared.exception;

public class ResourceNotFoundException extends RuntimeException {

  public ResourceNotFoundException(String resource, Object identifier) {
    super("%s with identifier %s not found".formatted(resource, identifier));
  }
}
