package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public static WebDriver createDriver(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            return new ChromeDriver();
        }

        throw new IllegalArgumentException(
                "Browser not supported: " + browser);
    }
}