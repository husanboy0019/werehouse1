package uz.com.appwarehouse.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.com.appwarehouse.dto.file.ProductFileDTO;
import uz.com.appwarehouse.entity.ProductFile;

@Mapper(componentModel = "spring")
public interface ProductFileMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "active", source = "active")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "originalName", source = "originalName")
    @Mapping(target = "size", source = "size")
    @Mapping(target = "mimeType", source = "mimeType")
    ProductFileDTO toDto(ProductFile file);

}
