package cde.mc.outageanalytics1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TicketNotFoundException extends Exception {
    public TicketNotFoundException(String message) {
        super(message);
    }
}
