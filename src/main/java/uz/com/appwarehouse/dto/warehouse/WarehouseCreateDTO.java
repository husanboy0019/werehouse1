package uz.com.appwarehouse.dto.warehouse;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class WarehouseCreateDTO {

    @NotBlank(message = "Name is required !!!")
    private String name;

}
