package rw.ba.kigali_barber.barber;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import rw.ba.kigali_barber.barber.dto.BarberRequestDto;
import rw.ba.kigali_barber.barber.exceptions.BarberExistsException;

@Service 
@RequiredArgsConstructor 
public class BarberService {
    private final BarberRepository barberRepository;
    private final BarberMapper barberMapper;

    @Transactional 
    public String create(BarberRequestDto dto){
        if(barberRepository.existsByPhone(dto.phone())){
            throw new BarberExistsException(dto.phone());
        }
        barberRepository.save(barberMapper.toEntity(dto));

        return "barber created successfully";
    }
    public List<BarberEntity> getAll(BarberRequestDto dto){
        return barberRepository.findAll();
    }
    public String getBarber(BarberRequestDto dto){
        return "barber created successfully";
    }
    public String updateBarber(BarberRequestDto dto){
        return "barber created successfully";
    }
}

