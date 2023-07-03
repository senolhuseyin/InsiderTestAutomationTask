package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class QualityAssurancePage extends Driver {

    @FindBy(css = ".btn-outline-secondary")
    public WebElement seeAllQAJobsButton;

    public QualityAssurancePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void clickSeeAllQAJobButton() {
        javascriptExecutor.executeScript("arguments[0].click();", seeAllQAJobsButton);
    }
}