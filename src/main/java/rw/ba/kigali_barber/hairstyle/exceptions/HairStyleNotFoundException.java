package rw.ba.kigali_barber.hairstyle.exceptions;

import java.util.Collection;
import java.util.UUID;

import rw.ba.kigali_barber.common.exception.ResourceNotFoundException;

public class HairStyleNotFoundException extends ResourceNotFoundException {
    public HairStyleNotFoundException(UUID id) {
        super("Hair style not found: " + id);
    }

    public HairStyleNotFoundException(Collection<UUID> ids) {
        super("Hair styles not found: " + ids);
    }
}
