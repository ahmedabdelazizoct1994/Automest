package gui.page;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class homePage {
    //variables
    private WebDriver driver;
     private final String url="https://www.google.com/";




    //locators
    public  static By googleLogo_image() {
        return By.xpath("//img[@alt='Google']");
    }

    public  static By googleSearch_textField() {
        return By.xpath("//input[@name='q']");
    }

    By googleSearch_textField = By.xpath("//input[@name='q']");



//constructor
    public homePage(WebDriver driver){
        this .driver=driver;
}


    /**
     * navigates to google homepage
     * @return self_reference
     */
    //keywords
    public homePage navigate(){
        BrowserActions.navigateToURL(driver,url);
    return this;

    }

    /**
     * searches for given string and press enter
     * @param query the string you want to search for
     * @return self_reference to enable fluent design
     */
    public  resultsPage searchForQuery(String query){
        (new ElementActions(driver)).type(homePage.googleSearch_textField(), query)
                .keyPress(homePage.googleSearch_textField(), Keys.ENTER);
        return new resultsPage(driver );
    }


}
