package com.hdbank.bankingcommon.domain.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Converter
@RequiredArgsConstructor
public class ObjectConverter implements AttributeConverter<Object, String> {

    // Lớp này dùng để chuyển từ Object sang String(Json) và ngược lại
    private final ObjectMapper objectMapper;

    @Override
    @SneakyThrows
    public String convertToDatabaseColumn(
            final Object object
    ) {
        return objectMapper.writeValueAsString(object);
    }

    @Override
    public Object convertToEntityAttribute(
            final String json
    ) {
        return objectMapper.convertValue(json, Object.class);
    }
}

