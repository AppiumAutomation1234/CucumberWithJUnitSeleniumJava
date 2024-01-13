package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    public WebDriver driver;
    public LandingPage(WebDriver driver){
       this.driver = driver;
    }

    private By landingPageSearchBox = By.xpath("//input[@placeholder='Search for Vegetables and Fruits']");
    private By landingPageProductName = By.xpath("//div[@class='product']//*[@class='product-name']");

    By productIncrementQuality = By.xpath("//div[@class='product']//a[@class='increment']");
    By addToCartButton = By.xpath("//button[text()='ADD TO CART']");
    public void landingPageSearchItem(String productName){
        driver.findElement(landingPageSearchBox).sendKeys(productName);
    }

    public String getLandingPageProductName(){
        return driver.findElement(landingPageProductName).getText();
    }

    public void incrementProductQuality() throws InterruptedException {

        Thread.sleep(4000);
        driver.findElement(productIncrementQuality).click();
    }

    public void clickAddToCartButton(){
        driver.findElement(addToCartButton).click();
    }
}
