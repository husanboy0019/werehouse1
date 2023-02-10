package uz.com.appwarehouse.dto.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.com.appwarehouse.dto.warehouse.WarehouseDTO;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Integer id;

    private boolean active;

    private String firstName;

    private String lastName;

    private String phone;

    private UUID uuid;

    private String password;

    private WarehouseDTO warehouse;

}
