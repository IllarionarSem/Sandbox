package driver;

import org.openqa.selenium.Capabilities;

public interface DriverSettings<T extends Capabilities> {
    T getCapabilities();
}
