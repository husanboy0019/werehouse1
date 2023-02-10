package uz.com.appwarehouse.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import uz.com.appwarehouse.dto.supplier.SupplierCreateDTO;
import uz.com.appwarehouse.dto.supplier.SupplierDTO;
import uz.com.appwarehouse.dto.supplier.SupplierUpdateDTO;
import uz.com.appwarehouse.entity.Supplier;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "active", source = "active")
    SupplierDTO toDto(Supplier category);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "phone", source = "phone")
    Supplier toEntity(SupplierCreateDTO dto);

    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "phone", source = "dto.phone")
    Supplier toEntity(@MappingTarget Supplier supplier, SupplierUpdateDTO dto);

}
