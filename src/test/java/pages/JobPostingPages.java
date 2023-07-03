package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;
import java.util.Objects;

public class JobPostingPages extends Driver {

    //Location of the job
    @FindBy(xpath = "(//div[@class='posting-categories']//div)[1]")
    public WebElement location;

    //Department of the job
    @FindBy(xpath = "(//div[@class='posting-categories']//div)[2]")
    public WebElement department;

    @FindBy(xpath = "//a[@class='postings-btn template-btn-submit shamrock']")
    public List<WebElement> applyNowButtons;

    public JobPostingPages() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public boolean isPositionContains(String position) {
        return driver.getTitle().contains(position);
    }

    public boolean isLocationContains(String location) {
        return Objects.equals(this.location.getText(), location);
    }

    public boolean isDepartmentContains(String department) {
        return Objects.equals(this.department.getText(), department);
    }

    public boolean isApplyNowButtonsDisplayed() {
        return applyNowButtons.size() == 2;
    }

    public void clickApplyNowButton() {
        applyNowButtons.get(0).click();
    }
}