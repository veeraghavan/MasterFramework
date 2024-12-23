package com.veeraraghavan.config.converters;

import enums.RemotePlatformEnums;
import enums.RunModeEnums;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.util.Map;

public class StringToRemotePlatformEnums implements Converter<RemotePlatformEnums> {
    @Override
    public RemotePlatformEnums convert(Method method, String platformName) {
        Map<String, RemotePlatformEnums> remotePlatformEnumsMap = Map.of("SELENIUM", RemotePlatformEnums.SELENIUM,
                "SELENOID", RemotePlatformEnums.SELENOID, "BROWSERSTACK", RemotePlatformEnums.BROWSERSTACK);
        return remotePlatformEnumsMap.getOrDefault(platformName.toUpperCase(), RemotePlatformEnums.SELENOID);
    }
}
