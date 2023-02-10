package uz.com.appwarehouse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.com.appwarehouse.enums.UnitType;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "income_items")
public class IncomeItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "income_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Income income;
    @Column(name = "income_id")
    private Integer incomeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "amount")
    private Integer amount;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "unit_type")
    private UnitType unitType;

    @Column(name = "cost")
    private Integer cost;

    @Column(name = "expiry")
    private Integer expiry;

}
