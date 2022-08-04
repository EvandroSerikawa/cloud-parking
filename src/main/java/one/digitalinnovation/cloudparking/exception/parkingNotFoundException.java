package one.digitalinnovation.cloudparking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class parkingNotFoundException extends RuntimeException {
    public parkingNotFoundException(String id) {

        super("Parking not found wiht id: "+ id);
    }
}
