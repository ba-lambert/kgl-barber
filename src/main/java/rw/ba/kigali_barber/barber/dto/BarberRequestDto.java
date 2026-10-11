package rw.ba.kigali_barber.barber.dto;

public record BarberRequestDto(String names, GenderDto gender, Long phone, AddressDto address) {
}
