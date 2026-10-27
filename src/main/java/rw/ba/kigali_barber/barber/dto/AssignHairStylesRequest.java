package rw.ba.kigali_barber.barber.dto;

import java.util.Set;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record AssignHairStylesRequest(@NotNull Set<UUID> hairStyleIds) {
}
