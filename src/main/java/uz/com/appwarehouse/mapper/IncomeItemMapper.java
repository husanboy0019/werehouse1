package uz.com.appwarehouse.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.com.appwarehouse.dto.income.IncomeItemCreateDTO;
import uz.com.appwarehouse.dto.income.IncomeItemDTO;
import uz.com.appwarehouse.entity.IncomeItem;
import uz.com.appwarehouse.mapper.qualifier.UnitTypeQualifier;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {
                ProductMapper.class,
                UnitTypeQualifier.class
        }
)
public interface IncomeItemMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "product", source = "product")
    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "unitType", source = "unitType")
    @Mapping(target = "cost", source = "cost")
    @Mapping(target = "expiry", source = "expiry")
    IncomeItemDTO toDto(IncomeItem item);

    List<IncomeItemDTO> toDto(List<IncomeItem> itemList);  // todo bunga mapping yozilmaydi chunki tepadagiga murojaat qiladi

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "incomeId", source = "incomeId")
    @Mapping(target = "productId", source = "productId")
    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "unitType", source = "unitTypeName", qualifiedByName = "mapUnitType")
    @Mapping(target = "cost", source = "cost")
    @Mapping(target = "expiry", source = "expiry")
    IncomeItem toEntity(IncomeItemCreateDTO dto);

}
