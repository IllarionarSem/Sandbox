package element;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static testcontext.TestContext.*;

@Log4j2
public class Interact {
    public void clickOn(WebElement element) {
        log.info("Click on element");
        getElemStateValidations().performWait(element, ElemStateValidation.State.BEFORE_CLICK);
        getJsExecutor().click(element);
    }

    public void clickOn(By by) {
        clickOn(findElement(by));
    }

    public void clearAndType(By by, String text) {
        clearAndType(findElement(by), text);
    }

    public void clearAndType(WebElement element, String text) {
        getElemStateValidations().performWait(element, ElemStateValidation.State.BEFORE_TYPE);
        getJsExecutor().clearAndType(element, text);
    }

    public String getText(WebElement element) {
        getElemStateValidations().performWait(element,ElemStateValidation.State.BEFORE_EXTRACT_TEXT);
        return getJsExecutor().getText(element);
    }

    public String getText(By by) {
        return getText(findElement(by));
    }

    public WebElement findElement(By by) {
        return getBrowser().getDriver().findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return getBrowser().getDriver().findElements(by);
    }
}
