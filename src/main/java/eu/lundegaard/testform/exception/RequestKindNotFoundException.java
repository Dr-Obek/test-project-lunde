package eu.lundegaard.testform.exception;

import org.springframework.http.HttpStatus;

public class RequestKindNotFoundException extends LundeException {

    public RequestKindNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
