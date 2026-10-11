package rw.ba.kigali_barber.barber;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BarberRepository extends JpaRepository<BarberEntity,UUID> {
    boolean existsByPhone(Long phone);
}
