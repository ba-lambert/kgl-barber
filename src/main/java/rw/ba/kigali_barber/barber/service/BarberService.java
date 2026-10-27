package rw.ba.kigali_barber.barber.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rw.ba.kigali_barber.barber.BarberEntity;
import rw.ba.kigali_barber.barber.BarberMapper;
import rw.ba.kigali_barber.barber.BarberRepository;
import rw.ba.kigali_barber.barber.dto.BarberRequestDto;
import rw.ba.kigali_barber.barber.exceptions.BarberExistsException;

@Service
public class BarberService {
    private final BarberRepository barberRepository;
    private final BarberMapper barberMapper;

    public BarberService(BarberRepository barberRepository, BarberMapper barberMapper) {
        this.barberMapper = barberMapper;
        this.barberRepository = barberRepository;
    }

    @Transactional
    public String create(BarberRequestDto dto) {
        if (barberRepository.existsByPhone(dto.phone())) {
            throw new BarberExistsException(dto.phone());
        }
        barberRepository.save(barberMapper.toEntity(dto));

        return "barber created successfully";
    }

    public List<BarberEntity> getAll(BarberRequestDto dto) {
        return barberRepository.findAll();
    }

    public String getBarber(BarberRequestDto dto) {
        return "barber created successfully";
    }

    public String updateBarber(BarberRequestDto dto) {
        return "barber created successfully";
    }
}
