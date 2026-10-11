package rw.ba.kigali_barber.barber.dto;

import java.util.UUID;

public record BarberDto(UUID id,String names, Long phone,AddressDto address, GenderDto gender) {
    
}
