package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import listeners.TestListener;
import pages.GooglePage;
import utilities.ExcelDataProvider;

@Listeners(TestListener.class)
public class GoogleTest extends BaseTest {
	
	@Test(retryAnalyzer = utilities.RetryAnalyzer.class)
	public void verifySearchResultsTitleIsNotEmpty() {

	    // Use the driver provided by BaseTest (no new WebDriver)
	    GooglePage googlePage = new GooglePage(driver);

	    // Perform search using existing page method
	    googlePage.search("Selenium WebDriver");

	    // Get the page title after search
	    String title = googlePage.getPageTitle();
	    System.out.println("Title after search: " + title);

	    // Verify title is not null/empty
	    Assert.assertFalse(title == null || title.trim().isEmpty(),
	            "Page title should not be empty after searching for 'Selenium WebDriver'");
	}


    @Test(retryAnalyzer = utilities.RetryAnalyzer.class)
    public void verifyGoogleTitle() {

        GooglePage googlePage = new GooglePage(driver);

        String title = googlePage.getPageTitle();

        System.out.println("Page Title: " + title);

         Assert.assertEquals(title, "Google");
        
    
        //Assert.assertEquals(title, "Wrong Title");
    }

    @Test(
        dataProvider = "searchData",
        dataProviderClass = ExcelDataProvider.class,
        retryAnalyzer = utilities.RetryAnalyzer.class
    )
    public void verifyGoogleSearch(String searchText) {

        GooglePage googlePage = new GooglePage(driver);

        googlePage.search(searchText);

        System.out.println("Search completed for google: " + searchText);
        
  
     // Explain how TestNG gets searchText from ExcelDataProvider class and how it is used in the test method
        
        
        
        				
        
    }
}