package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

@Log4j2
public class FireFoxDriverManager extends DriverManager<FirefoxOptions> {
    @Override
    protected WebDriver createLocalDriver() {
        return new FirefoxDriver(getCapabilities());
    }

    @Override
    public FirefoxOptions getCapabilities() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("intl.accept_languages", "en");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setProfile(profile);
//         set options as needed
        return firefoxOptions;
    }
}
