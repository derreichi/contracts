package de.reichi.database.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  private static final Logger logger = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);

  @ExceptionHandler(value = {ConstraintViolationException.class})
  protected ResponseEntity<Object> handleInvalidParameter(final ConstraintViolationException ex, final WebRequest request) {

    logger.error(ex.getMessage());
    logger.debug("ConstraintViolation: ", ex);
    Errors errors = new Errors(ex.getConstraintViolations().stream().map(vio -> vio.getPropertyPath().toString() + " -> " + vio.getMessage()).collect(Collectors.toList()));

    return this.handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
  }
}
