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
    public void verifyGoogleTitle() {

        GooglePage googlePage = new GooglePage(driver);

        String title = googlePage.getPageTitle();

        System.out.println("Page Title: " + title);

        // Assert.assertEquals(title, "Google");
        Assert.assertEquals(title, "Wrong Title");
    }

    @Test(
        dataProvider = "searchData",
        dataProviderClass = ExcelDataProvider.class,
        retryAnalyzer = utilities.RetryAnalyzer.class
    )
    public void verifyGoogleSearch(String searchText) {

        GooglePage googlePage = new GooglePage(driver);

        googlePage.search(searchText);

        System.out.println("Search completed for: " + searchText);
    }
}