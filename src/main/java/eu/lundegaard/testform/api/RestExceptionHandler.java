package eu.lundegaard.testform.api;

import eu.lundegaard.testform.exception.ExceptionResponseDto;
import eu.lundegaard.testform.exception.LundeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String VALIDATION_ERROR = "Validation error.";

    @ExceptionHandler(value = {LundeException.class})
    protected ResponseEntity<Object> handleLundegaardException(LundeException ex, WebRequest request) {
        log.error("{}", ex.getMessage(), ex);
        return handleExceptionInternal(ex, buildResponse(ex),
                new HttpHeaders(), ex.getStatus(), request);
    }

    @ExceptionHandler({Exception.class})
    protected ResponseEntity<Object> handleInternalServerErrorException(Exception ex, WebRequest request) {
        log.error("{}", ex.getMessage(), ex);
        return handleExceptionInternal(ex, buildResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR),
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        log.error("{}", ex.getMessage(), ex);
        String message = VALIDATION_ERROR;
        if (ex.getFieldError() != null) {
            message = ex.getFieldError().getField() + ": " + ex.getFieldError().getDefaultMessage();
        }
        return new ResponseEntity<>(new ExceptionResponseDto(Timestamp.valueOf(LocalDateTime.now()), message, status.value()), headers, status);
    }

    private ExceptionResponseDto buildResponse(LundeException ex) {
        return buildResponse(ex.getMessage(), ex.getStatus());
    }

    private ExceptionResponseDto buildResponse(String message, HttpStatus status) {
        return new ExceptionResponseDto(Timestamp.valueOf(LocalDateTime.now()), message, status.value());
    }
}
