package rw.ba.kigali_barber.barber.dto;

import jakarta.persistence.Embeddable;

@Embeddable 
public record AddressDto(String district, String sector, String cell) {
}
