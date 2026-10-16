package rw.ba.kigali_barber.hairstyle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import rw.ba.kigali_barber.common.BaseEntity;

@Entity 
@Table (name = "hair_style")
@Getter 
@Setter 
public class HairStyleEntity extends BaseEntity {
    @Column (unique = true,nullable = false)
    private String name;
    @Column (name = "price",nullable = false)
    private int price;
}
