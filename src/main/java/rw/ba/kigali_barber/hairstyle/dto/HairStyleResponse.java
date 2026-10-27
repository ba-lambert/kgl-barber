package rw.ba.kigali_barber.hairstyle.dto;

import java.util.UUID;

public record HairStyleResponse(UUID id, String name, Integer price, Integer duration) {

}
