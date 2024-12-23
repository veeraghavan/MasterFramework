package com.veeraraghavan.config;

import org.aeonbits.owner.ConfigCache;

public final class BrowserstackConfigFactory {

    private BrowserstackConfigFactory() {}

    public static BrowserstackConfig getConfig() {
        BrowserstackConfig browserstackConfig = ConfigCache.getOrCreate(BrowserstackConfig.class);
        return browserstackConfig;
    }
}
