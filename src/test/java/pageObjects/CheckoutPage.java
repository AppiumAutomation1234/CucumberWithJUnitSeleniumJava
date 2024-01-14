package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.GenericUtils;

public class CheckoutPage extends GenericUtils {

    public WebDriver driver;
    public CheckoutPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }


    By cartIcon = By.xpath("//a[@class='cart-icon']//img");
    By proceedToCheckoutButton = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
    By productNameInCartPage = By.xpath("//*[text()='Product Name']//..//..//..//..//tbody//*[@class='product-name']");
    By enterPromoCodeTextbox = By.xpath("//input[@class='promoCode']");
    By placeOrderButton = By.xpath("//button[text()='Place Order']");
    By applyButton = By.xpath("//button[text()='Apply']");

    public void checkoutItems(){
        elementOperations("click",cartIcon,"","");
        //driver.findElement(cartIcon).click();
        elementOperations("click",proceedToCheckoutButton,"","");
        //driver.findElement(proceedToCheckoutButton).click();
    }

    public String getCartPageProductName() throws InterruptedException {

        waitUntilElementLocated(productNameInCartPage);
        return returnStringValue(productNameInCartPage);
        //return driver.findElement(productNameInCartPage).getText();
    }

    public boolean verifyPromoButton () throws InterruptedException {
        waitUntilElementLocated(applyButton);
        return isElementDisplayed(applyButton);
        //return driver.findElement(applyButton).isDisplayed();
    }

    public boolean verifyPlaceOrder () throws InterruptedException {
        waitUntilElementLocated(placeOrderButton);
        return isElementDisplayed(placeOrderButton);
        //return driver.findElement(placeOrderButton).isDisplayed();
    }

    public void enterPromoCode(String productName) throws InterruptedException {
        //Thread.sleep(3000);
        waitUntilElementLocated(enterPromoCodeTextbox);
        //driver.findElement(enterPromoCodeTextbox).sendKeys(productName);
        elementOperations("sendKeys",enterPromoCodeTextbox,productName,productName);
    }
}
