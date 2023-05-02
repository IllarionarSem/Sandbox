package element;

import configuration.Config;
import lombok.extern.log4j.Log4j2;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class JsExecutor {
    Config config = ConfigFactory.create(Config.class);
    private JavascriptExecutor executor;

    public JsExecutor(WebDriver driver) {
        executor = (JavascriptExecutor) driver;
    }

    public void clearAndType(WebElement element, String text) {
        log.info("Clear field and type : " + text);
        executor.executeScript(config.jsClearField(), element);
        executor.executeScript(config.jsTypeValue(), element, text);
    }

    public String getText(WebElement element) {
        return (String) executor.executeScript(config.jsInnerText(), element);
    }

    public void click(WebElement element) {
        log.info("Send click on element");
        executor.executeScript(config.jsClick(), element);
    }
}
