package uz.com.appwarehouse.dto.warehouse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseDTO {

    private Integer id;

    private boolean active;

    private String name;

}
