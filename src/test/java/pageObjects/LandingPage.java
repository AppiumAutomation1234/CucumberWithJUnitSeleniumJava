package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.GenericUtils;

public class LandingPage extends GenericUtils {

    public WebDriver driver;
    public LandingPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    By landingPageSearchBox = By.xpath("//input[@placeholder='Search for Vegetables and Fruits']");
    By landingPageProductName = By.xpath("//div[@class='product']//*[@class='product-name']");

    By productIncrementQuality = By.xpath("//div[@class='product']//a[@class='increment']");
    By addToCartButton = By.xpath("//button[text()='ADD TO CART']");
    public void landingPageSearchItem(String productName){
        waitUntilElementLocated(landingPageSearchBox);
        elementOperations("sendKeys",landingPageSearchBox,productName,productName);
        //driver.findElement(landingPageSearchBox).sendKeys(productName);
    }

    public String getLandingPageProductName(){

        //return driver.findElement(landingPageProductName).getText();
        waitUntilElementLocated(landingPageProductName);
        return returnStringValue(landingPageProductName);
    }

    public void incrementProductQuality() throws InterruptedException {

        //Thread.sleep(4000);
        //driver.findElement(productIncrementQuality).click();

        waitUntilElementLocated(productIncrementQuality);
        elementOperations("click",productIncrementQuality,"","");
    }

    public void clickAddToCartButton(){

        waitUntilElementLocated(addToCartButton);
        elementOperations("click",addToCartButton,"","");
        //driver.findElement(addToCartButton).click();
    }
}
