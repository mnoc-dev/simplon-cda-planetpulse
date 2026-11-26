package co.simplon.planet_pulse.exceptions;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

/**
 * Handles all the exceptions specified below.
 */
@RestControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

    /**
     *
     * @param ex Exception thrown
     * @param request Request that caused the exception
     * @return Response entity with details about the error
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(RuntimeException ex, WebRequest request){

        ProblemDetail details = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        details.setDetail(ex.getMessage());

        return super.handleExceptionInternal(ex, details, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
