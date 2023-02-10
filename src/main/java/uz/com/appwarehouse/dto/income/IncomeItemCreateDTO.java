package uz.com.appwarehouse.dto.income;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class IncomeItemCreateDTO {

    @NotNull(message = "Product id is required !!!")
    private Integer productId;

    @NotNull(message = "Amount is required !!!")
    private Integer amount;

    @NotBlank(message = "Unit type is required !!!")
    private String unitTypeName;

    @NotNull(message = "Cost is required !!!")
    private Integer cost;

    @NotNull(message = "Expiry is required !!!")
    private Integer expiry;

    private Integer incomeId; // todo hidden column

}
