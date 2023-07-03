package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class OpenPositionsPage extends Driver {

    @FindBy(xpath = "//select[@id='filter-by-location']")
    public WebElement filterByLocation;

    @FindBy(xpath = "//select[@id='filter-by-department']")
    public WebElement filterByDepartment;

    @FindBy(css = "#jobs-list")
    public WebElement jobList;

    @FindBy(xpath = "(//div[@class='position-list-item-wrapper bg-light']//a)")
    public List<WebElement> viewRoleButtons;

    public OpenPositionsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void selectLocation(String location) {
        Select selectLocation = new Select(filterByLocation);
        selectLocation.selectByVisibleText(location);
    }

    public void selectDepartment(String department) {
        Select selectDepartment = new Select(filterByDepartment);
        selectDepartment.selectByVisibleText(department);
    }

    public boolean isJobListDisplayed() {
        return jobList.isDisplayed();
    }

    public int getViewRoleButtonsSize() {
        return viewRoleButtons.size();
    }

    public void clickViewRoleButton(int i) {
        javascriptExecutor.executeScript("arguments[0].click();", viewRoleButtons.get(i));
    }
}