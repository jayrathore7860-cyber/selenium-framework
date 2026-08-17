package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.WaitUtils;

public class GooglePage {

    private WebDriver driver;
    private WaitUtils waitUtils;
    // Locator
    private By searchBox = By.name("q");

    // Constructor
    public GooglePage(WebDriver driver) {

        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    // Get page title
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Search on Google

    	
 
    public void search(String text) {

        WebElement searchElement =
                waitUtils.waitForElementVisible(searchBox);

        searchElement.sendKeys(text);

        searchElement.submit();   
        
    }
}