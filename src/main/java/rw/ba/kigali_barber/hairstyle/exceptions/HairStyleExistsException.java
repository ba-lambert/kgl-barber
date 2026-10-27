package rw.ba.kigali_barber.hairstyle.exceptions;

import rw.ba.kigali_barber.common.exception.ResourceConflictException;

public class HairStyleExistsException extends ResourceConflictException {
    public HairStyleExistsException(String name) {
        super("Hair style already exists: " + name);
    }
}
