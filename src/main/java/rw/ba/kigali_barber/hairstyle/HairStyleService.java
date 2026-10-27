package rw.ba.kigali_barber.hairstyle;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rw.ba.kigali_barber.hairstyle.dto.HairStyleRequest;
import rw.ba.kigali_barber.hairstyle.dto.HairStyleResponse;
import rw.ba.kigali_barber.hairstyle.exceptions.HairStyleExistsException;
import rw.ba.kigali_barber.hairstyle.exceptions.HairStyleNotFoundException;

@Service
public class HairStyleService {
    private final HairStyleRepository hairStyleRepository;

    public HairStyleService(HairStyleRepository hairStyleRepository) {
        this.hairStyleRepository = hairStyleRepository;
    }

    @Transactional
    public HairStyleResponse create(HairStyleRequest request) {
        String name = request.name().trim();
        if (hairStyleRepository.existsByName(name)) {
            throw new HairStyleExistsException(name);
        }
        return HairStyleMapper.toResponse(hairStyleRepository.save(HairStyleMapper.toEntity(request)));
    }

    @Transactional(readOnly = true)
    public List<HairStyleResponse> getAll() {
        return hairStyleRepository.findAll().stream().map(HairStyleMapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public HairStyleResponse getById(UUID id) {
        return HairStyleMapper.toResponse(findOrThrow(id));
    }

    @Transactional
    public HairStyleResponse update(UUID id, HairStyleRequest request) {
        HairStyleEntity entity = findOrThrow(id);
        String name = request.name().trim();
        if (hairStyleRepository.existsByNameAndIdNot(name, id)) {
            throw new HairStyleExistsException(name);
        }
        HairStyleMapper.apply(entity, request);
        return HairStyleMapper.toResponse(hairStyleRepository.save(entity));
    }

    @Transactional
    public void delete(UUID id) {
        hairStyleRepository.delete(findOrThrow(id));
    }

    private HairStyleEntity findOrThrow(UUID id) {
        return hairStyleRepository.findById(id).orElseThrow(() -> new HairStyleNotFoundException(id));
    }
}
