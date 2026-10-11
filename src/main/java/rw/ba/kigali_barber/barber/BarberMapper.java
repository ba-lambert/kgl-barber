package rw.ba.kigali_barber.barber;

import org.springframework.stereotype.Component;

import rw.ba.kigali_barber.barber.dto.AddressDto;
import rw.ba.kigali_barber.barber.dto.BarberRequestDto;

@Component
public class BarberMapper {

    public BarberEntity toEntity(BarberRequestDto dto) {
        return BarberEntity.create(
            dto.names(),
            dto.phone(),
            Gender.valueOf(dto.gender().name()),
            toAddress(dto.address())
        );
    }

    private Address toAddress(AddressDto dto) {
        return new Address(dto.district(), dto.sector(), dto.cell());
    }
}
