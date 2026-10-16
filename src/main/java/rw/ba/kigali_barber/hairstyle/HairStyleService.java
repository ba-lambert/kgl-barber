package rw.ba.kigali_barber.hairstyle;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import rw.ba.kigali_barber.hairstyle.dto.HairStyleRequest;
import rw.ba.kigali_barber.hairstyle.dto.HairStyleResponse;

@Service 
public class HairStyleService {
    private final HairStyleRepository hairStyleRepository;

    public HairStyleService(HairStyleRepository hairStyleRepository){
        this.hairStyleRepository = hairStyleRepository;
    }

    @Transactional 
    HairStyleResponse create(HairStyleRequest request){
        HairStyleEntity newHairstyle = new HairStyleEntity();
        newHairstyle.setName(request.name());
        newHairstyle.setPrice(request.price());
        HairStyleEntity savedEntity = hairStyleRepository.save(newHairstyle);
        return HairStyleMapper.toResponse(savedEntity);
    }
}
