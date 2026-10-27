package rw.ba.kigali_barber.hairstyle;

import rw.ba.kigali_barber.hairstyle.dto.HairStyleRequest;
import rw.ba.kigali_barber.hairstyle.dto.HairStyleResponse;

public final class HairStyleMapper {
    private HairStyleMapper() {
    }

    public static HairStyleResponse toResponse(HairStyleEntity entity) {
        return new HairStyleResponse(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getDuration());
    }

    public static HairStyleEntity toEntity(HairStyleRequest request) {
        HairStyleEntity entity = new HairStyleEntity();
        apply(entity, request);
        return entity;
    }

    public static void apply(HairStyleEntity entity, HairStyleRequest request) {
        entity.setName(request.name().trim());
        entity.setPrice(request.price());
        entity.setDuration(request.duration());
    }
}
