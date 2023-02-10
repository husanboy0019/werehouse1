package uz.com.appwarehouse.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.com.appwarehouse.dto.outcome.OutcomeItemCreateDTO;
import uz.com.appwarehouse.dto.outcome.OutcomeItemDTO;
import uz.com.appwarehouse.entity.OutcomeItem;
import uz.com.appwarehouse.mapper.qualifier.UnitTypeQualifier;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {
                ProductMapper.class,
                UnitTypeQualifier.class
        }
)
public interface OutcomeItemMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "product", source = "product")
    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "unitType", source = "unitType")
    @Mapping(target = "cost", source = "cost")
    OutcomeItemDTO toDto(OutcomeItem item);

    List<OutcomeItemDTO> toDto(List<OutcomeItem> itemList);  // todo bunga mapping yozilmaydi chunki tepadagiga murojaat qiladi

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "outcomeId", source = "outcomeId")
    @Mapping(target = "productId", source = "productId")
    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "unitType", source = "unitTypeName", qualifiedByName = "mapUnitType")
    @Mapping(target = "cost", source = "cost")
    OutcomeItem toEntity(OutcomeItemCreateDTO dto);

}
