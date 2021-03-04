package eu.lundegaard.testform.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class LundeException extends RuntimeException {

    private HttpStatus status;
    private String message;
}
