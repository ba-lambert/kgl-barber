package rw.ba.kigali_barber.barber;

import jakarta.persistence.Embeddable;

@Embeddable
public record Address(String district, String sector, String cell) {
}
