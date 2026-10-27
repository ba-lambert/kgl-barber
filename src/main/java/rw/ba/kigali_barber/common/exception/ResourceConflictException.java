package rw.ba.kigali_barber.common.exception;

/** Signals that a request clashes with existing state; mapped to HTTP 409. */
public class ResourceConflictException extends RuntimeException {
    public ResourceConflictException(String message) {
        super(message);
    }
}
