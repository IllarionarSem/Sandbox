package app;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import configuration.Config;
import driver.DriverManagerFactory;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;

public class AppModule extends AbstractModule {
    Config config = ConfigFactory.create(Config.class);

    @Override
    protected void configure() {
        super.configure();
    }

    @Provides
    public WebDriver webDriver() {
        return DriverManagerFactory.getManager(config.browserType()).getDriver();
    }

    @Provides
    public Browser browser(WebDriver driver) {
        return new Browser(driver);
    }
}
