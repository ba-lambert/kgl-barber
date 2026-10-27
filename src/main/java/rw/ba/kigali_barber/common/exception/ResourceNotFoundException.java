package rw.ba.kigali_barber.common.exception;

/** Signals that a requested resource does not exist; mapped to HTTP 404. */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
