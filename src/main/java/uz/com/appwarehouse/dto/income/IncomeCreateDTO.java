package uz.com.appwarehouse.dto.income;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString
public class IncomeCreateDTO {

    @NotNull(message = "Warehouse id is required !!!")
    private Integer warehouseId;

    @NotNull(message = "Supplier id is required !!!")
    private Integer supplierId;

    @NotBlank(message = "Currency type is required !!!")
    private String currencyTypeName;

    @NotBlank(message = "Invoice number is required !!!")
    private String invoice;

    @NotEmpty(message = "Product items are required !!!")
    private List<IncomeItemCreateDTO> items;

}
