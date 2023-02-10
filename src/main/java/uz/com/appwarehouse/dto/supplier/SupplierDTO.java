package uz.com.appwarehouse.dto.supplier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDTO {

    private Integer id;

    private boolean active;

    private String name;

    private String phone;

}
