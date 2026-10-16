package rw.ba.kigali_barber.hairstyle;

import rw.ba.kigali_barber.hairstyle.dto.HairStyleResponse;

public class HairStyleMapper {
    public static  HairStyleResponse toResponse(HairStyleEntity entity){
        return new HairStyleResponse(
            entity.getId(),
            entity.getName(),
            entity.getPrice()
        );
    }
}
