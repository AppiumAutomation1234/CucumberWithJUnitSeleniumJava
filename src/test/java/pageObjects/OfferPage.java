package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.GenericUtils;

public class OfferPage extends GenericUtils {

    public WebDriver driver;
    public OfferPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    By dealsLink = By.xpath("//a[text()='Top Deals']");
    By offerPageSearchBox = By.xpath("//input[@id='search-field']");
    By offerPageProductName = By.xpath("//tr//td[1]");

    public void clickOnDealsLink(){
        driver.findElement(dealsLink).click();
    }

    public void offerPageSearchItem(String productName){
        waitUntilElementLocated(offerPageSearchBox);
        //driver.findElement(enterPromoCodeTextbox).sendKeys(productName);
        elementOperations("sendKeys",offerPageSearchBox,productName,productName);
        //driver.findElement(offerPageSearchBox).sendKeys(productName);
    }

    public String getOfferPageProductName(){

        waitUntilElementLocated(offerPageProductName);
        return returnStringValue(offerPageProductName);
        //return driver.findElement(offerPageProductName).getText();
    }


}
