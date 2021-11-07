package gui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class resultsPage {
    //variables
   private WebDriver driver;

    //constructor
    public resultsPage(WebDriver driver ){
        this.driver=driver;
    }


    //locators

    public static By resultStats_label() {
        return By.id("result-stats");
    }

    public  static By googleLogo_image() {
        return By.xpath("//img[@alt='Google']");
    }


}
