package uz.com.appwarehouse.dto.category;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class CategoryUpdateDTO {

    @NotNull(message = "Id is required !!!")
    private Integer id;

    @NotBlank(message = "Name is required !!!")
    private String name;

}
