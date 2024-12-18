package com.veeraraghavan.config;

import org.aeonbits.owner.ConfigCache;

public final class ConfigFactory {

    private ConfigFactory() {}

    public static FrameworkConfig getConfig() {
        FrameworkConfig config =  ConfigCache.getOrCreate(FrameworkConfig.class);
        return config;
    }
}
