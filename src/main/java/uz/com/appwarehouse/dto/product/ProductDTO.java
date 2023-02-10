package uz.com.appwarehouse.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.com.appwarehouse.dto.category.CategoryDTO;
import uz.com.appwarehouse.enums.UnitType;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Integer id;

    private boolean active;

    private String name;

    private CategoryDTO category;

    private UUID uuid;

    private UnitType unitType;

}
