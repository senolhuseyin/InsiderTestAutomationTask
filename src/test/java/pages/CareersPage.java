package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.Objects;

public class CareersPage extends Driver {

    @FindBy(xpath = "(//div[@class='row'])[3]")
    public WebElement ourLocationsBlock;

    @FindBy(css = "div.elementor-widget-wrap.e-swiper-container")
    public WebElement lifeAtInsiderBlock;

    @FindBy(css = ".btn.btn-outline-secondary")
    public WebElement seeAllTeamsButton;

    @FindBy(xpath = "//a[.='Quality Assurance']")
    public WebElement QATeamButton;

    public CareersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void clickSeeAllTeamsButton() {
        javascriptExecutor.executeScript("arguments[0].click();", seeAllTeamsButton);
    }

    public void clickQATeamButton() {
        javascriptExecutor.executeScript("arguments[0].click();", QATeamButton);
    }

    public boolean isCareerPageOpened() {
        return Objects.equals(driver.getTitle(), "Insider Careers");
    }

    public boolean isOurLocationsBlockDisplayed() {
        return ourLocationsBlock.isDisplayed();
    }

    public boolean isTeamsBlockDisplayed() {
        return seeAllTeamsButton.isDisplayed();
    }

    public boolean isLifeAtInsiderBlockDisplayed() {
        return lifeAtInsiderBlock.isDisplayed();
    }
}