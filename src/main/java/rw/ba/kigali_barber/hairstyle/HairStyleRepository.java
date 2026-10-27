package rw.ba.kigali_barber.hairstyle;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HairStyleRepository extends JpaRepository<HairStyleEntity, UUID> {
    boolean existsByName(String name);

    boolean existsByNameAndIdNot(String name, UUID id);
}
