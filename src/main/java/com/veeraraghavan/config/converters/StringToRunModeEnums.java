package com.veeraraghavan.config.converters;

import enums.BrowserTypeEnums;
import enums.RunModeEnums;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.util.Map;

public class StringToRunModeEnums implements Converter<RunModeEnums> {
    @Override
    public RunModeEnums convert(Method method, String runMode) {
        Map<String, RunModeEnums> runModeEnumsMap = Map.of("LOCAL", RunModeEnums.LOCAL,
                "REMOTE", RunModeEnums.REMOTE);
        return runModeEnumsMap.getOrDefault(runMode.toUpperCase(), RunModeEnums.LOCAL);
    }
}
