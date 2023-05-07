package element;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.function.Consumer;

import static testcontext.TestContext.getConditionalWait;
import static testcontext.TestContext.getElemStateValidations;

@Log4j2
public class ElemStateValidation {

    public enum State {
        BEFORE_CLICK(getElemStateValidations().toBeVisible, getElemStateValidations().toBeClickable),
        BEFORE_TYPE(getElemStateValidations().toBeVisible, getElemStateValidations().toBeClickable),
        BEFORE_EXTRACT_TEXT(getElemStateValidations().toBeVisible);

        private final Consumer<WebElement>[] consumers;

        @SafeVarargs
        State(Consumer<WebElement>... consumers) {
            this.consumers = consumers;
        }
    }

    public Consumer<WebElement> toBeVisible = element -> getConditionalWait().until(ExpectedConditions.visibilityOf(element));

    public Consumer<WebElement> toBeClickable = element -> getConditionalWait().until(ExpectedConditions.elementToBeClickable(element));

    public void performWait(WebElement element, State states) {
        performWait(element, states.consumers);
    }

    @SafeVarargs
    public final void performWait(WebElement element, Consumer<WebElement>... consumers) {
        List.of(consumers).forEach($ -> $.accept(element));
    }
}
