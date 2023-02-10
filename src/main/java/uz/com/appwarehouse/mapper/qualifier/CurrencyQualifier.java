package uz.com.appwarehouse.mapper.qualifier;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import uz.com.appwarehouse.enums.CurrencyType;

@Component
@Mapper
public class CurrencyQualifier {

    @Named("mapCurrencyType")
    public CurrencyType mapCurrencyType(String currencyTypeName) {
        return CurrencyType.getByName(currencyTypeName);
    }

}
