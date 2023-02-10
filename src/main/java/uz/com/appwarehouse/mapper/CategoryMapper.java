package uz.com.appwarehouse.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import uz.com.appwarehouse.dto.category.CategoryCreateDTO;
import uz.com.appwarehouse.dto.category.CategoryDTO;
import uz.com.appwarehouse.dto.category.CategoryUpdateDTO;
import uz.com.appwarehouse.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "active", source = "active")
    @Mapping(target = "name", source = "name")
    CategoryDTO toDto(Category category);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "name", source = "name")
    Category toEntity(CategoryCreateDTO dto);

    @Mapping(target = "name", source = "dto.name")
    Category toEntity(@MappingTarget Category category, CategoryUpdateDTO dto);

}
