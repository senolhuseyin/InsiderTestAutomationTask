package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FormPages extends Driver {

    public FormPages() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public boolean isFormPageOpened() {
        return driver.getCurrentUrl().contains("https://jobs.lever.co/useinsider/");
    }

    public String getTitleOfCurrentJob() {
        return driver.getTitle();
    }
}
