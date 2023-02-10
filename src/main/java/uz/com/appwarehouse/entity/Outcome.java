package uz.com.appwarehouse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.com.appwarehouse.enums.CurrencyType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "outcomes")
public class Outcome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "date_time", columnDefinition = "timestamp default now()")
    private LocalDateTime dateTime = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Warehouse warehouse;
    @Column(name = "warehouse_id")
    private Integer warehouseId;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "currency_type")
    private CurrencyType currencyType;

    @Column(name = "invoice")
    private String invoice;  // factoring number

    @Column(name = "uuid")
    private UUID uuid = UUID.randomUUID();

}
