package com.veeraraghavan.config.converters;

import enums.BrowserTypeEnums;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.util.Map;

public class StringToBrowserTypeEnum implements Converter {
    @Override
    public Object convert(Method method, String browserType) {
        Map<String, BrowserTypeEnums> browserTypeEnumsMap = Map.of("CHROME", BrowserTypeEnums.CHROME,
                "FIREFOX", BrowserTypeEnums.FIREFOX);
        return browserTypeEnumsMap.getOrDefault(browserType.toUpperCase(), BrowserTypeEnums.CHROME);
    }
}
