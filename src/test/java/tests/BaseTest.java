package tests;

import com.steam.page.LandingPage;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static testcontext.TestContext.getBrowser;

@Log4j2
public abstract class BaseTest {

    protected LandingPage landingPage = new LandingPage();
    @BeforeMethod
    public void beforeMethod() {
        landingPage.openPage();
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        getBrowser().quit();
    }
}
