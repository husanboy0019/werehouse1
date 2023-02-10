package uz.com.appwarehouse.mapper.qualifier;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import uz.com.appwarehouse.enums.UnitType;

@Component
@Mapper
public class UnitTypeQualifier {

    @Named("mapUnitType")
    public UnitType mapUnitType(String unitTypeName) {
        return UnitType.getByName(unitTypeName);
    }

}
