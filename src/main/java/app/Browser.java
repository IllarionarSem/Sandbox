package app;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Browser {
    private final WebDriver driver;

    public Browser(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(String url) {
        log.info(String.format("Navigate to '%s'", url));
        getDriver().get(url);
    }

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public String getTitle() {
        return getDriver().getTitle();
    }

    public void quit() {
        log.info("Quit Browser");
        if (getDriver() != null) {
            getDriver().close();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
