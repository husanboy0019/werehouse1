package uz.com.appwarehouse.dto.outcome;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.com.appwarehouse.dto.product.ProductDTO;
import uz.com.appwarehouse.enums.UnitType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OutcomeItemDTO {

    private Integer id;

    private ProductDTO product;

    private Integer amount;

    private UnitType unitType;

    private Integer cost;

}
