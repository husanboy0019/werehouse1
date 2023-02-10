package uz.com.appwarehouse.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum CurrencyType {

    UZS(860, 'N', (short) 2),
    USD(840, 'F', (short) 2),
    EUR(978, 'F', (short) 2),
    RUB(643, 'F', (short) 2),
    GBP(826, 'F', (short) 2),
    JPY(392, 'F', (short) 0),
    KZT(398, 'F', (short) 2),
    CNY(156, 'F', (short) 2),
    CHF(756, 'F', (short) 2),
    KRW(410, 'F', (short) 2),
    ALS(111, 'A', (short) 0),
    UNKNOWN(-1, '.', (short) 0);

    private final Integer code;
    private final Character character;
    private final short scale;

    public static CurrencyType getByName(final String name) {
        return Arrays.stream(CurrencyType.values())
                .filter(currency -> currency.name().equalsIgnoreCase(name))
                .findFirst()
                .orElse(UNKNOWN);
    }

}
