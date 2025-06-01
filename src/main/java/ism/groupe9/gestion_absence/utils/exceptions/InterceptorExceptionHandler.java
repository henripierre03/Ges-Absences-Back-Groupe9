package ism.groupe9.gestion_absence.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InterceptorExceptionHandler {
    @ExceptionHandler(EntityNotFoundExceptions.class)
    public ResponseEntity<Object> entityNotFound(EntityNotFoundExceptions ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
