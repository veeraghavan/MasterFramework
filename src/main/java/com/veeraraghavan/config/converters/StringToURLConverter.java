package com.veeraraghavan.config.converters;

import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class StringToURLConverter implements Converter<URL> {
    @Override
    public URL convert(Method method, String stringUrl) {
        try {
            return new URL(stringUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
