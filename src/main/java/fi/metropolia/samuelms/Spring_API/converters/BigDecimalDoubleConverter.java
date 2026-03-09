package fi.metropolia.samuelms.Spring_API.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.math.BigDecimal;

@Converter
public class BigDecimalDoubleConverter implements AttributeConverter<Double, BigDecimal> {
    @Override
    public BigDecimal convertToDatabaseColumn(Double aDouble) {
        return aDouble == null ? null : BigDecimal.valueOf(aDouble);
    }

    @Override
    public Double convertToEntityAttribute(BigDecimal bigDecimal) {
        return bigDecimal.doubleValue();
    }
}
