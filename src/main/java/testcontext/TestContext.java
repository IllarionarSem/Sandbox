package testcontext;

import browser.Browser;
import configuration.Config;
import driver.DriverManager;
import driver.DriverManagerFactory;
import element.ElemStateValidation;
import element.Interact;
import element.JsExecutor;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestContext {
    private static Config config = ConfigFactory.create(Config.class);
    private static final ThreadLocal<TestContext> INSTANCE_CONTAINER = ThreadLocal.withInitial(TestContext::new);
    private final Browser browser;
    private final ElemStateValidation elemStateValidation;
    private final JsExecutor jsExecutor;
    private final WebDriverWait webDriverWait;
    private final Interact interact;
    private final Actions actions;

    public static TestContext getInstance() {
        return INSTANCE_CONTAINER.get();
    }

    private TestContext() {
        this(DriverManagerFactory.getManager(config.browserType()));
    }

    private TestContext(DriverManager<?> driverManager) {
        this.browser = new Browser(driverManager.getDriver());
        this.webDriverWait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(config.timeOut()));
        this.elemStateValidation = new ElemStateValidation();
        this.jsExecutor = new JsExecutor();
        this.actions = new Actions(driverManager.getDriver());
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

    public static Actions getActions() {
        return getInstance().actions;
    }
}
