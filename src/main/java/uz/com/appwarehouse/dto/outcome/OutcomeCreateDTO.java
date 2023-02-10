package uz.com.appwarehouse.dto.outcome;

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
public class OutcomeCreateDTO {

    @NotNull(message = "Warehouse id is required !!!")
    private Integer warehouseId;

    @NotBlank(message = "Currency type is required !!!")
    private String currencyTypeName;

    @NotBlank(message = "Invoice number is required !!!")
    private String invoice;

    @NotEmpty(message = "Product items are required !!!")
    private List<OutcomeItemCreateDTO> items;

}
