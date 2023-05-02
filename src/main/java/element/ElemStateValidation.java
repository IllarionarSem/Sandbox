package element;

import configuration.Config;
import lombok.extern.log4j.Log4j2;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;
import java.util.function.Consumer;

import static testcontext.TestContext.getBrowser;
import static testcontext.TestContext.getConditionalWait;

@Log4j2
public class ElemStateValidation {
    private Config config = ConfigFactory.create(Config.class);

    public Consumer<WebElement> toBeVisible = element -> getConditionalWait().until(ExpectedConditions.visibilityOf(element));

    public Consumer<WebElement> toBeClickable = element -> getConditionalWait().until(ExpectedConditions.elementToBeClickable(element));

    @SafeVarargs
    public final void performWait(WebElement element, Consumer<WebElement>... consumers) {
//        setImplicitToZero();
        List.of(consumers).forEach($ -> $.accept(element));
//        setImplicitToDefault();
    }

    private void setImplicitToZero() {
//        getBrowser().getDriver().manage().timeouts().implicitlyWait(Duration.ZERO);
    }

    private void setImplicitToDefault() {
//        getBrowser().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(config.timeOut()));
    }
}
