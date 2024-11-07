package fact.it.exampleprojectdtoserviceexec.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationException extends RuntimeException {

  public ValidationException() {
    super();
  }

  public ValidationException(final String message) {
    super(message);
  }
}

