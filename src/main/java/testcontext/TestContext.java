package testcontext;

import app.Browser;
import configuration.Config;
import driver.DriverManagerFactory;
import driver.DriverType;
import element.ElemStateValidation;
import element.Interact;
import element.JsExecutor;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestContext {
    private Config config = ConfigFactory.create(Config.class);
    private static final ThreadLocal<TestContext> INSTANCE_CONTAINER = ThreadLocal.withInitial(TestContext::new);
    private final Browser browser;
    private final ElemStateValidation elemStateValidation;
    private final JsExecutor jsExecutor;
    private final WebDriverWait webDriverWait;
    private final Interact interact;
    private final Actions actions;

    public static TestContext getInstance() {
        if (INSTANCE_CONTAINER.get() == null) {
            INSTANCE_CONTAINER.set(new TestContext());
        }
        return INSTANCE_CONTAINER.get();
    }

    private TestContext() {
        this.browser = new Browser(DriverManagerFactory.getManager(config.browserType()).getDriver());
        this.webDriverWait = new WebDriverWait(browser.getDriver(), Duration.ofSeconds(10));
        this.elemStateValidation = new ElemStateValidation();
        this.jsExecutor = new JsExecutor(browser.getDriver());
        this.actions = new Actions(browser.getDriver());
        this.interact = new Interact();
    }

    public static Browser getBrowser() {
        return getInstance().browser;
    }

    public static Interact getInteract() {
        return getInstance().interact;
    }

    public static JsExecutor getJsExecutor() {
        return getInstance().jsExecutor;
    }

    public static ElemStateValidation getElemStateValidations() {
        return getInstance().elemStateValidation;
    }

    public static WebDriverWait getConditionalWait() {
        return getInstance().webDriverWait;
    }
}
