package uz.com.appwarehouse.dto.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString
public class ProductCreateDTO {

    @NotBlank(message = "Name is required !!!")
    private String name;

    @NotNull(message = "Category id is required !!!")
    private Integer categoryId;

    @NotBlank(message = "Name is required !!!")
    private String unitTypeName;

    private List<Integer> fileIds;

}
