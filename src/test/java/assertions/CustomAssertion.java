package assertions;

import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.Collection;

public class CustomAssertion {

    @Step("{2}")
    public static void assertEquals(Collection<?> actual, Collection<?> expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    @Step("{2}")
    public static void assertEquals(Integer actual, Integer expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }
}
