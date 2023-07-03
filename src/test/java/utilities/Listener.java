package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

import static utilities.Driver.driver;

public class Listener implements ITestListener {
    public void onTestFailure(ITestResult iTestResult) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File("reports/failure.png"));
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }
}
