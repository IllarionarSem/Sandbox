package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Log4j2
public class ChromeDriverManager extends DriverManager<ChromeOptions> {

    @Override
    public WebDriver createLocalDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(getCapabilities());
    }

    @Override
    public ChromeOptions getCapabilities() {
        ChromeOptions chromeOptions = new ChromeOptions();
        // set options, capabilities as needed
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("safebrowsing.enabled", "true");
        prefs.put("intl.accept_languages", "en");
        chromeOptions.setExperimentalOption("prefs", prefs);
        chromeOptions.addArguments("--remote-allow-origins=*");
        return chromeOptions;
    }
}
