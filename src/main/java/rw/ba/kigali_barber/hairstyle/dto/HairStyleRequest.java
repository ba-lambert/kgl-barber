package rw.ba.kigali_barber.hairstyle.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record HairStyleRequest(
        @NotBlank @Size(max = 200) String name,
        @NotNull @Positive Integer price,
        @NotNull @Positive Integer duration) {
}
