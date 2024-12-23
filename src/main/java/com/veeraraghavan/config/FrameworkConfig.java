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
        "file:${user.dir}/src/test/resources/config.properties"
})
public interface FrameworkConfig extends Config {

    @ConverterClass(StringToBrowserTypeEnum.class)
    BrowserTypeEnums browser();

    @ConverterClass(StringToRunModeEnums.class)
    RunModeEnums runMode();

    @ConverterClass(StringToRemotePlatformEnums.class)
    RemotePlatformEnums remotePlatform();

    @ConverterClass(StringToURLConverter.class)
    URL seleniumGridUrl();

    @ConverterClass(StringToURLConverter.class)
    URL selenoidUrl();
}
