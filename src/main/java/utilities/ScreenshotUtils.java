package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    public static String captureScreenshot(WebDriver driver, String testName) {

        String screenshotDirectory =
                System.getProperty("user.dir") + "/screenshots/";

        File directory = new File(screenshotDirectory);

        if (!directory.exists()) {
            directory.mkdirs();
        }

        String screenshotPath =
                screenshotDirectory + testName + ".png";

        File source = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        File destination = new File(screenshotPath);

        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return destination.getAbsolutePath();
    }
}