package uz.com.appwarehouse.dto.supplier;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class SupplierUpdateDTO {

    @NotNull(message = "Id is required !!!")
    private Integer id;

    @NotBlank(message = "Name is required !!!")
    private String name;

    @NotBlank(message = "Phone is required !!!")
    private String phone;

}
