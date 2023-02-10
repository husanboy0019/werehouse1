package uz.com.appwarehouse.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import uz.com.appwarehouse.dto.warehouse.WarehouseCreateDTO;
import uz.com.appwarehouse.dto.warehouse.WarehouseDTO;
import uz.com.appwarehouse.dto.warehouse.WarehouseUpdateDTO;
import uz.com.appwarehouse.entity.Warehouse;

@Mapper(componentModel = "spring")
public interface WarehouseMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "active", source = "active")
    WarehouseDTO toDto(Warehouse category);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "name", source = "name")
    Warehouse toEntity(WarehouseCreateDTO dto);

    @Mapping(target = "name", source = "dto.name")
    Warehouse toEntity(@MappingTarget Warehouse warehouse, WarehouseUpdateDTO dto);

}
