package listeners;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getExtentReports() {

        if (extent == null) {

            String reportPath = System.getProperty("user.dir")
                    + "/test-output/ExtentReport.html";

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(reportPath);

            sparkReporter.config().setReportName("Selenium Automation Report");
            sparkReporter.config().setDocumentTitle("Test Execution Report");

            extent = new ExtentReports();

            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Project", "Selenium Framework");
            extent.setSystemInfo("Tester", "Automation Team");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Browser", "Chrome");
        }

        return extent;
    }
}