package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {

    public WebDriver driver;
    public OfferPage(WebDriver driver){
        this.driver = driver;
    }

    private By dealsLink = By.xpath("//a[text()='Top Deals']");
    private By offerPageSearchBox = By.xpath("//input[@id='search-field']");
    private By offerPageProductName = By.xpath("//tr//td[1]");

    public void clickOnDealsLink(){
        driver.findElement(dealsLink).click();
    }

    public void offerPageSearchItem(String productName){
        driver.findElement(offerPageSearchBox).sendKeys(productName);
    }

    public String getOfferPageProductName(){

        return driver.findElement(offerPageProductName).getText();
    }


}
