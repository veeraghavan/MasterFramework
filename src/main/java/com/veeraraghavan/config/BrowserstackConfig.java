package com.veeraraghavan.config;

import com.veeraraghavan.config.converters.StringToBrowserTypeEnum;
import com.veeraraghavan.config.converters.StringToRemotePlatformEnums;
import com.veeraraghavan.config.converters.StringToRunModeEnums;
import com.veeraraghavan.config.converters.StringToURLConverter;
import enums.BrowserTypeEnums;
import enums.RemotePlatformEnums;
import enums.RunModeEnums;
import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/browserstack.properties"
})
public interface BrowserstackConfig extends Config {

    @Key("username")
    String userName();

    @Key("accessKey")
    String key();

    @DefaultValue("https://${userName}:${key}@hub-cloud.browserstack.com/wd/hub")
    @ConverterClass(StringToURLConverter.class)
    URL browserstackURL();
}
