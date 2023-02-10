package uz.com.appwarehouse.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.com.appwarehouse.dto.outcome.OutcomeCreateDTO;
import uz.com.appwarehouse.dto.outcome.OutcomeDTO;
import uz.com.appwarehouse.entity.Outcome;
import uz.com.appwarehouse.mapper.qualifier.CurrencyQualifier;

@Mapper(componentModel = "spring",
        uses = {
                WarehouseMapper.class,
                OutcomeItemMapper.class,
                CurrencyQualifier.class
        }
)
public interface OutcomeMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "dateTime", source = "dateTime")
    @Mapping(target = "warehouse", source = "warehouse")
    @Mapping(target = "currencyType", source = "currencyType")
    @Mapping(target = "invoice", source = "invoice")
    @Mapping(target = "uuid", source = "uuid")
    OutcomeDTO toDto(Outcome outcome);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dateTime", ignore = true)
    @Mapping(target = "warehouseId", source = "warehouseId")
    @Mapping(target = "currencyType", source = "currencyTypeName", qualifiedByName = "mapCurrencyType")
    @Mapping(target = "invoice", source = "invoice")
    @Mapping(target = "uuid", ignore = true)
    Outcome toEntity(OutcomeCreateDTO dto);

}
