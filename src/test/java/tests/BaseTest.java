package tests;

import com.steam.page.LandingPage;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static testcontext.TestContext.getBrowser;

@Log4j2
public abstract class BaseTest {
    @BeforeMethod
    public void beforeMethod() {
        new LandingPage().openPage();
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        getBrowser().quit();
    }
}
