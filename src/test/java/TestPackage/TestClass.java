package TestPackage;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import gui.page.homePage;
import gui.page.resultsPage;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass {
  private  WebDriver driver;
   JSONFileManager testData= new JSONFileManager("src/test/resources/TestDataFiles/google.json");

    @Test(description = "Check the google logo is displayed")
    @Description("""
             Given the browser is open
             When I navigate to google home 
             Then the google logo is will be displayed 
            """)
    public void CheckGoogleLogo() {
        new homePage(driver).navigate();
  Validations.verifyThat().element(driver, homePage.googleLogo_image()).matchesReferenceImage()
                .withCustomReportMessage("assert the image is displayed properly").perform();
    }


    @Test(description = "Check the stats of shaft_Engine results is not empty")
    @Description("""
             Given the browser is open
             When I navigate to google home and search for shaft engine
             Then the results stats  is will be displayed 
            """)
    public void checkTheStatsIsNotEmpty() {

        new homePage(driver).navigate().searchForQuery(testData.getTestData("searchQuery"));



        Validations.verifyThat().element(driver, resultsPage.resultStats_label()).text().doesNotEqual("").
                withCustomReportMessage("assert the label is not empty").perform();

        BrowserActions.closeCurrentWindow(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = DriverFactory.getDriver();

    }

    @AfterMethod
    public void afterMethod() {
        BrowserActions.closeCurrentWindow(driver);
    }


}
