package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.Objects;

public class HomePage extends Driver {

    @FindBy(css = "#wt-cli-accept-all-btn")
    public WebElement acceptAllCookies;

    @FindBy(xpath = "//span[text()='More']")
    public WebElement moreMenuButton;

    @FindBy(xpath = "//h5[text()='Careers']")
    public WebElement careersButton;

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void clickAcceptAllCookies() {
        acceptAllCookies.click();
    }

    public void clickMoreMenuButton() {
        moreMenuButton.click();
    }

    public void clickCareersButton() {
        careersButton.click();
    }

    public boolean isHomePageOpened() {
        return Objects.equals(driver.getTitle(), "#1 Leader in Individualized, Cross-Channel CX — Insider");
    }
}