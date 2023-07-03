package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Driver {
    protected static WebDriver driver;
    protected static JavascriptExecutor javascriptExecutor;
    protected static WebDriverWait webDriverWait;

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

            //Settings for the test to work better(maximize window and wait elements to load)
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            javascriptExecutor = (JavascriptExecutor) driver;
        }
        return driver;
    }

    public void getTheDriverAndGoHomePage() {
        Driver.getDriver().get(ConfigReader.getProperty("homePageUrl"));
    }

    public void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

    public void switchToNewTab(String mainTab) {
        for (String windowHandle : driver.getWindowHandles()) {
            if (!mainTab.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void switchToMainTab(String mainTab) {
        driver.switchTo().window(mainTab);
    }
}