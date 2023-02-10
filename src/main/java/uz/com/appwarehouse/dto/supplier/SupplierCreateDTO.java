package uz.com.appwarehouse.dto.supplier;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class SupplierCreateDTO {

    @NotBlank(message = "Name is required !!!")
    private String name;

    @NotBlank(message = "Phone is required !!!")
    private String phone;

}
