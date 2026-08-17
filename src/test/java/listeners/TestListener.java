package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import utilities.ScreenshotUtils;

public class TestListener implements ITestListener {

    private static ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = ExtentReportManager
                .getExtentReports()
                .createTest(result.getName());

        test.info("Test execution started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test passed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        Object testClass = result.getInstance();

        WebDriver driver = ((BaseTest) testClass).getDriver();

        String testName = result.getName();

        String screenshotPath =
                ScreenshotUtils.captureScreenshot(driver, testName);

        test.addScreenCaptureFromPath(screenshotPath);

        System.out.println(
                "Screenshot captured for failed test: " + testName);
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.skip("Test skipped");
    }

    @Override
    public void onFinish(
            org.testng.ITestContext context) {

        ExtentReportManager
                .getExtentReports()
                .flush();
    }
}
