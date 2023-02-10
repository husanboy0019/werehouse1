package uz.com.appwarehouse.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum UnitType {

    METER("m", "Length"),
    KILOGRAM("kg", "Mass"),
    KELVIN("K", "Temperature"),
    SECOND("s", "Time"),
    LITRE("L", "Capacity/Volume"),
    AMPERE("A", "Current"),
    MOLE("mol", "Amount of Substance"),
    PCS("pcs", "The number of things"),
    UNKNOWN("unknown", "unknown");

    private final String symbol;
    private final String description;

    public static UnitType getByName(final String name) {
        return Arrays.stream(UnitType.values())
                .filter(unitType -> unitType.name().equalsIgnoreCase(name))
                .findFirst()
                .orElse(UNKNOWN);
    }

}
