package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import utilities.Driver;
import utilities.Listener;

import java.time.Duration;

@Listeners(Listener.class)

public class InsiderTest extends Driver {

    HomePage homePage = new HomePage();
    CareersPage careersPage = new CareersPage();
    QualityAssurancePage qualityAssurancePage = new QualityAssurancePage();
    OpenPositionsPage openPositionsPage = new OpenPositionsPage();
    JobPostingPages jobPostingPages = new JobPostingPages();
    FormPages formPages = new FormPages();

    @BeforeTest
    public void beforeTest() {
        getTheDriverAndGoHomePage();
        homePage.clickAcceptAllCookies();
    }

    @Test
    public void insiderTest() throws InterruptedException {

        Assert.assertTrue(homePage.isHomePageOpened(), "Home Page is not opened.");
        System.out.println("Home Page is opened.");

        homePage.clickMoreMenuButton();
        homePage.clickCareersButton();
        System.out.println("Clicked More->Careers and went to the careers page");

        Assert.assertTrue(careersPage.isCareerPageOpened(), "Careers Page not opened.");
        Assert.assertTrue(careersPage.isOurLocationsBlockDisplayed(), "Locations Block is not displayed.");
        Assert.assertTrue(careersPage.isTeamsBlockDisplayed(), "Teams Block is not displayed.");
        Assert.assertTrue(careersPage.isLifeAtInsiderBlockDisplayed(), "Life At Insider Block is not displayed.");
        System.out.println("Default elements of career page displayed");

        careersPage.clickSeeAllTeamsButton();
        careersPage.clickQATeamButton();
        qualityAssurancePage.clickSeeAllQAJobButton();
        openPositionsPage.selectLocation("Istanbul, Turkey");
        openPositionsPage.selectDepartment("Quality Assurance");
        Thread.sleep(Duration.ofSeconds(3));
        System.out.println("Clicked Teams->QATeam->SeeAllQAJobs and jobs are filtered");

        Assert.assertTrue(openPositionsPage.isJobListDisplayed(), "Job List is not displayed.");
        System.out.println("Job List is displayed.");

        //Click all the viewRoleButton's in order and check all the jobs pages
        for (int i = 0; i < openPositionsPage.getViewRoleButtonsSize(); i++) {

            //Save the page to switch to the original window when the process in the opened tab is finished
            String mainTab = driver.getWindowHandle();

            openPositionsPage.clickViewRoleButton(i);
            switchToNewTab(mainTab);

            Assert.assertTrue(jobPostingPages.isPositionContains("Software Q"), formPages.getTitleOfCurrentJob() + "\n---job's position does not contain Quality Assurance");
            Assert.assertTrue(jobPostingPages.isLocationContains("ISTANBUL, TURKEY /"), formPages.getTitleOfCurrentJob() + "\n---job's location does not contain Istanbul, Turkey");
            Assert.assertTrue(jobPostingPages.isDepartmentContains("QUALITY ASSURANCE /"), formPages.getTitleOfCurrentJob() + "\n---job's department does not contain Quality Assurance");
            Assert.assertTrue(jobPostingPages.isApplyNowButtonsDisplayed(), formPages.getTitleOfCurrentJob() + "\n---job does not have Apply Now buttons");

            jobPostingPages.clickApplyNowButton();
            switchToNewTab(mainTab);

            Assert.assertTrue(formPages.isFormPageOpened(), formPages.getTitleOfCurrentJob() + "\n---Apply Now button does not redirect us to Lever Application form page");

            //Close the tab which opened for the job posting and form page
            driver.close();

            switchToMainTab(mainTab);
        }

        System.out.println("All job postings contains required qualifications and \n" +
                "Apply Now button redirects us to Lever Application form page");
    }

    @AfterTest
    public void afterTest() {
        closeDriver();
    }
}