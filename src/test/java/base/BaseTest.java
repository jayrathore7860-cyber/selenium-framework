package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.ConfigReader;
import utilities.DriverFactory;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() throws IOException {

        // Load configuration
        ConfigReader.loadProperties();

        // Read browser from config file
        String browser = ConfigReader.getProperty("browser");

        // Start browser
        if (browser.equalsIgnoreCase("chrome")) {
        	driver = DriverFactory.createDriver("chrome");
        }

        // Maximize browser
        driver.manage().window().maximize();

        // Open URL from config file
        driver.get(ConfigReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
    
 // Getter
    public WebDriver getDriver() {
        return driver;
    }
    
    
}