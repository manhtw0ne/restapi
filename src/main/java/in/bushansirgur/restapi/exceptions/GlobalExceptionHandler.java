package in.bushansirgur.restapi.exceptions;

import in.bushansirgur.restapi.io.ErrorObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ErrorObject handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        log.error("Throwing the ResourceNotFoundException from GlobalExceptionHandler {}", ex.getMessage());
        return ErrorObject.builder()
                .errorCode("DATA_NOT_FOUND")
                .statusCode(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .timestamp(new Date())
                .build();
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ItemExistsException.class)
    public ErrorObject handleItemExistsException(ItemExistsException ex, WebRequest request ) {
        log.error("Throwing the ItemExistsException from GlobalExceptionHandler {}", ex.getMessage());
        return ErrorObject.builder()
                .errorCode("DATA_EXISTS")
                .statusCode(HttpStatus.CONFLICT.value())
                .message(ex.getMessage())
                .timestamp(new Date())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorObject handleGeneralException(Exception ex, WebRequest request) {
        log.error("Throwing the Exception from GlobalExceptionHandler {}", ex.getMessage());
        return ErrorObject.builder()
                .errorCode("UNEXPECTED_ERROR")
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(ex.getMessage())
                .timestamp(new Date())
                .build();
    }
}
