package rw.ba.kigali_barber.barber;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rw.ba.kigali_barber.common.BaseEntity;

@Entity
@Table(name = "barbers")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BarberEntity extends BaseEntity {

    @Column(nullable = false, length = 200)
    private String names;

    @Column(nullable = false)
    private Long phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Gender gender;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "district", column = @Column(name = "address_district", nullable = false, length = 100)),
        @AttributeOverride(name = "sector", column = @Column(name = "address_sector", nullable = false, length = 100)),
        @AttributeOverride(name = "cell", column = @Column(name = "address_cell", nullable = false, length = 100))
    })
    private Address address;

    public static BarberEntity create(String names, Long phone, Gender gender, Address address) {
        BarberEntity barber = new BarberEntity();
        barber.setNames(names);
        barber.setPhone(phone);
        barber.setGender(gender);
        barber.setAddress(address);
        return barber;
    }
}
