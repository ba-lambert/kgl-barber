package rw.ba.kigali_barber.barber.exceptions;

public class BarberExistsException extends RuntimeException {
    public  BarberExistsException(Long phone){
        super("Burber with this phone number already exists" + phone);
    }
}
