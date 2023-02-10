package uz.com.appwarehouse.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import uz.com.appwarehouse.dto.product.ProductCreateDTO;
import uz.com.appwarehouse.dto.product.ProductDTO;
import uz.com.appwarehouse.dto.product.ProductUpdateDTO;
import uz.com.appwarehouse.entity.Product;
import uz.com.appwarehouse.mapper.qualifier.UnitTypeQualifier;

@Mapper(componentModel = "spring",
        uses = {
                CategoryMapper.class,
                UnitTypeQualifier.class
        }
)
public interface ProductMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "active", source = "active")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "uuid", source = "uuid")
    @Mapping(target = "unitType", source = "unitType")
    ProductDTO toDto(Product product);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "categoryId", source = "categoryId")
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "unitType", source = "unitTypeName", qualifiedByName = "mapUnitType")
    Product toEntity(ProductCreateDTO dto);

    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "categoryId", source = "dto.categoryId")
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "unitType", source = "dto.unitTypeName", qualifiedByName = "mapUnitType")
    Product toEntity(@MappingTarget Product product, ProductUpdateDTO dto);

}
