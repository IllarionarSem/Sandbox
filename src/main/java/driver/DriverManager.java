package driver;

import configuration.Config;
import lombok.extern.log4j.Log4j2;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

@Log4j2
public abstract class DriverManager<T extends Capabilities> implements DriverSettings<T> {
    protected Config config = ConfigFactory.create(Config.class);

    abstract protected WebDriver createLocalDriver();

    public WebDriver getDriver() {
        return config.execType().equals("remote") ? createRemoteDriver() : createLocalDriver();
    }

    protected WebDriver createRemoteDriver() {
        RemoteWebDriver webDriver;
        try {
            webDriver = new RemoteWebDriver(new URL(config.seleniumGridURL()), getCapabilities());
        } catch (MalformedURLException e) {
            log.error("GRID URL is not accessible");
            throw new RuntimeException(e);
        }
        webDriver.setFileDetector(new LocalFileDetector());
        return webDriver;
    }
}
