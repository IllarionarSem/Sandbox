package configuration;

import driver.DriverType;

@org.aeonbits.owner.Config.LoadPolicy(org.aeonbits.owner.Config.LoadType.MERGE)
@org.aeonbits.owner.Config.Sources({
        "classpath:global_config.properties",
        "file:src/main/resources/${env.properties}.properties",
        "classpath:javascript.properties"})
public interface Config extends org.aeonbits.owner.Config {
    @Key("browserType")
    DriverType browserType();

    @Key("execType")
    @DefaultValue("local")
    String execType();

    @Key("seleniumGridURL")
    String seleniumGridURL();

    @Key("getInnerText")
    String jsInnerText();

    @Key("typeValue")
    String jsTypeValue();

    @Key("clearField")
    String jsClearField();

    @Key("timeOut")
    Integer timeOut();

    @Key("click")
    String jsClick();
}
