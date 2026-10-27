package rw.ba.kigali_barber.barber.exceptions;

import java.util.UUID;

import rw.ba.kigali_barber.common.exception.ResourceNotFoundException;

public class BarberNotFoundException extends ResourceNotFoundException {
    public BarberNotFoundException(UUID id) {
        super("Barber not found: " + id);
    }
}
