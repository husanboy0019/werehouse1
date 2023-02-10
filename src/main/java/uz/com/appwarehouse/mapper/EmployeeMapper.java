package uz.com.appwarehouse.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import uz.com.appwarehouse.dto.employee.EmployeeCreateDTO;
import uz.com.appwarehouse.dto.employee.EmployeeDTO;
import uz.com.appwarehouse.dto.employee.EmployeeUpdateDTO;
import uz.com.appwarehouse.entity.Employee;

@Mapper(componentModel = "spring", uses = WarehouseMapper.class)
public interface EmployeeMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "active", source = "active")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "uuid", source = "uuid")
    @Mapping(target = "password", source = "password")  // todo aslida parol response da qaytarilmaydi
    @Mapping(target = "warehouse", source = "warehouse")
    EmployeeDTO toDto(Employee employee);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "warehouseId", source = "warehouseId")
    Employee toEntity(EmployeeCreateDTO dto);

    @Mapping(target = "firstName", source = "dto.firstName")
    @Mapping(target = "lastName", source = "dto.lastName")
    @Mapping(target = "phone", source = "dto.phone")
    @Mapping(target = "password", source = "dto.password")
    @Mapping(target = "warehouseId", source = "dto.warehouseId")
    Employee toEntity(@MappingTarget Employee employee, EmployeeUpdateDTO dto);

}
