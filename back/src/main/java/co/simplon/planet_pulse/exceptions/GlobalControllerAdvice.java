package co.simplon.planet_pulse.exceptions;

import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
        ProblemDetail details = ProblemDetail.forStatus(status);

        List<ObjectError> ValidationErrors =  ex.getBindingResult().getAllErrors();

        Map<String, String> properties = new HashMap<>();

        for (ObjectError error : ValidationErrors) {

            String errorName = error.getObjectName(); // Name of the object that is not valid

            if(error instanceof FieldError){ // In case the validation error comes from a field
                errorName = ((FieldError) error).getField();
            }
            properties.put(errorName, error.getDefaultMessage());
        }

        details.setProperty("errors", properties);

        return super.handleExceptionInternal(ex, details, headers, status, request);
    }

}
