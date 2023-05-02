package driver;

public class DriverManagerFactory {
    public static DriverManager<?> getManager(DriverType driverType) {
        DriverManager<?> driverManager = null;
        switch (driverType) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FireFoxDriverManager();
                break;
        }
        return driverManager;
    }
}
