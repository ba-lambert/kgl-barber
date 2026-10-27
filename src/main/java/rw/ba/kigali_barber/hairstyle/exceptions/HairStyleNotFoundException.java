package rw.ba.kigali_barber.hairstyle.exceptions;

import java.util.UUID;

import rw.ba.kigali_barber.common.exception.ResourceNotFoundException;

public class HairStyleNotFoundException extends ResourceNotFoundException {
    public HairStyleNotFoundException(UUID id) {
        super("Hair style not found: " + id);
    }
}
