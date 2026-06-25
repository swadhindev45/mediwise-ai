package mediwise_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SymptomNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleSymptomNotFound(SymptomNotFoundException ex) {
        return ex.getMessage();
    }
}