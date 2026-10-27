package rw.ba.kigali_barber.barber.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rw.ba.kigali_barber.barber.BarberEntity;
import rw.ba.kigali_barber.barber.BarberRepository;
import rw.ba.kigali_barber.barber.exceptions.BarberNotFoundException;
import rw.ba.kigali_barber.hairstyle.HairStyleEntity;
import rw.ba.kigali_barber.hairstyle.HairStyleMapper;
import rw.ba.kigali_barber.hairstyle.HairStyleRepository;
import rw.ba.kigali_barber.hairstyle.dto.HairStyleResponse;
import rw.ba.kigali_barber.hairstyle.exceptions.HairStyleNotFoundException;

@Service
public class BarberHairStyleService {
    private final BarberRepository barberRepository;
    private final HairStyleRepository hairStyleRepository;

    public BarberHairStyleService(BarberRepository barberRepository, HairStyleRepository hairStyleRepository) {
        this.barberRepository = barberRepository;
        this.hairStyleRepository = hairStyleRepository;
    }

    @Transactional(readOnly = true)
    public List<HairStyleResponse> getHairStyles(UUID barberId) {
        return findBarberOrThrow(barberId).getHairStyles().stream().map(HairStyleMapper::toResponse).toList();
    }

    @Transactional
    public List<HairStyleResponse> replaceHairStyles(UUID barberId, Set<UUID> hairStyleIds) {
        BarberEntity barber = findBarberOrThrow(barberId);
        barber.setHairStyles(new HashSet<>(findHairStylesOrThrow(hairStyleIds)));
        return barber.getHairStyles().stream().map(HairStyleMapper::toResponse).toList();
    }

    @Transactional
    public void removeHairStyle(UUID barberId, UUID hairStyleId) {
        BarberEntity barber = findBarberOrThrow(barberId);
        boolean removed = barber.getHairStyles().removeIf(style -> style.getId().equals(hairStyleId));
        if (!removed) {
            throw new HairStyleNotFoundException(hairStyleId);
        }
    }

    private BarberEntity findBarberOrThrow(UUID barberId) {
        return barberRepository.findById(barberId).orElseThrow(() -> new BarberNotFoundException(barberId));
    }

    private List<HairStyleEntity> findHairStylesOrThrow(Set<UUID> hairStyleIds) {
        List<HairStyleEntity> found = hairStyleRepository.findAllById(hairStyleIds);
        if (found.size() != hairStyleIds.size()) {
            Set<UUID> missing = new HashSet<>(hairStyleIds);
            found.forEach(style -> missing.remove(style.getId()));
            throw new HairStyleNotFoundException(missing);
        }
        return found;
    }
}
