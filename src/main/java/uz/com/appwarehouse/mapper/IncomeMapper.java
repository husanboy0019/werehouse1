package uz.com.appwarehouse.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.com.appwarehouse.dto.income.IncomeCreateDTO;
import uz.com.appwarehouse.dto.income.IncomeDTO;
import uz.com.appwarehouse.entity.Income;
import uz.com.appwarehouse.mapper.qualifier.CurrencyQualifier;

@Mapper(componentModel = "spring",
        uses = {
                WarehouseMapper.class,
                SupplierMapper.class,
                IncomeItemMapper.class,
                CurrencyQualifier.class
        }
)
public interface IncomeMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "dateTime", source = "dateTime")
    @Mapping(target = "warehouse", source = "warehouse")
    @Mapping(target = "supplier", source = "supplier")
    @Mapping(target = "currencyType", source = "currencyType")
    @Mapping(target = "invoice", source = "invoice")
    @Mapping(target = "uuid", source = "uuid")
    IncomeDTO toDto(Income income);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dateTime", ignore = true)
    @Mapping(target = "warehouseId", source = "warehouseId")
    @Mapping(target = "supplierId", source = "supplierId")
    @Mapping(target = "currencyType", source = "currencyTypeName", qualifiedByName = "mapCurrencyType")
    @Mapping(target = "invoice", source = "invoice")
    @Mapping(target = "uuid", ignore = true)
    Income toEntity(IncomeCreateDTO dto);

}
