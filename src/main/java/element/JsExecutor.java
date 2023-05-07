package element;

import configuration.Config;
import lombok.extern.log4j.Log4j2;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static testcontext.TestContext.getBrowser;

@Log4j2
public class JsExecutor {
    Config config = ConfigFactory.create(Config.class);

    public void clearAndType(WebElement element, String text) {
        log.info("Clear field and type : " + text);
        getJsExec().executeScript(config.jsClearField(), element);
        getJsExec().executeScript(config.jsTypeValue(), element, text);
    }

    public String getText(WebElement element) {
        return (String) getJsExec().executeScript(config.jsInnerText(), element);
    }

    public void click(WebElement element) {
        log.info("Send click on element");
        getJsExec().executeScript(config.jsClick(), element);
    }

    private JavascriptExecutor getJsExec() {
        return (JavascriptExecutor) getBrowser().getDriver();
    }
}
