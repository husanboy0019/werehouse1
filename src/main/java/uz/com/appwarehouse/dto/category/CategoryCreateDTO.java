package uz.com.appwarehouse.dto.category;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class CategoryCreateDTO {

    @NotBlank(message = "Name is required !!!")
    private String name;

}
