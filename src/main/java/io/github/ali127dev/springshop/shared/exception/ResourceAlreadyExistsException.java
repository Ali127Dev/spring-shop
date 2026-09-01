package io.github.ali127dev.springshop.shared.exception;

public class ResourceAlreadyExistsException extends RuntimeException {

  public ResourceAlreadyExistsException(String resource, Object identifier) {
    super("%s with identifier %s already exists".formatted(resource, identifier));
  }
}
