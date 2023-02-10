package uz.com.appwarehouse.dto.employee;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class EmployeeCreateDTO {

    @NotBlank(message = "First name is required !!!")
    private String firstName;

    @NotBlank(message = "Last name is required !!!")
    private String lastName;

    @NotBlank(message = "Phone is required !!!")
    private String phone;

    @NotBlank(message = "Password is required !!!")
    private String password;

    @NotNull(message = "Warehouse id is required !!!")
    private Integer warehouseId;

}
