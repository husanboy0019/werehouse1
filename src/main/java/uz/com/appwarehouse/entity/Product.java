package uz.com.appwarehouse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.com.appwarehouse.base.BaseEntity;
import uz.com.appwarehouse.enums.UnitType;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Category category;
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "uuid")
    private UUID uuid = UUID.randomUUID();

    @Enumerated(value = EnumType.STRING)
    @Column(name = "unit_type")
    private UnitType unitType;

}
