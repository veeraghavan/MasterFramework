package com.veeraraghavan.config;

import com.veeraraghavan.config.converters.StringToBrowserTypeEnum;
import enums.BrowserTypeEnums;
import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/config.properties"
})
public interface FrameworkConfig extends Config {

    @ConverterClass(StringToBrowserTypeEnum.class)
    BrowserTypeEnums browser();
}
