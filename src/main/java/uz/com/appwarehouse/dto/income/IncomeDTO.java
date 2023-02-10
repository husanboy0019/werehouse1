package uz.com.appwarehouse.dto.income;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.com.appwarehouse.dto.supplier.SupplierDTO;
import uz.com.appwarehouse.dto.warehouse.WarehouseDTO;
import uz.com.appwarehouse.enums.CurrencyType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IncomeDTO {

    private Integer id;

    private LocalDateTime dateTime;

    private WarehouseDTO warehouse;

    private SupplierDTO supplier;

    private CurrencyType currencyType;

    private String invoice;

    private UUID uuid;

    private List<IncomeItemDTO> items;

}
