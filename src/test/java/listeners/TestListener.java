package listeners;

import io.qameta.allure.Attachment;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

import static testcontext.TestContext.getBrowser;

@Log4j2
public class TestListener extends BaseTest implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        log.info(String.format("%s Test Passed", result.getMethod().getConstructorOrMethod().getName()));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testMethodName = result.getMethod().getConstructorOrMethod().getName();
        log.info(String.format("%s Test Failed", testMethodName));
        takeScreenshot();
        saveTextLog(String.format("%s Test Failed, with screenshot", testMethodName));
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) getBrowser().getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public String saveTextLog(String message) {
        return message;
    }
}
