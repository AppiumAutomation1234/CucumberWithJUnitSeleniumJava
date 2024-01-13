package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    public WebDriver driver;
    public CheckoutPage(WebDriver driver){

        this.driver = driver;
    }


    By cartIcon = By.xpath("//a[@class='cart-icon']//img");
    By proceedToCheckoutButton = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
    By productNameInCartPage = By.xpath("//*[text()='Product Name']//..//..//..//..//tbody//*[@class='product-name']");
    By enterPromoCodeTextbox = By.xpath("//input[@class='promoCode']");
    By placeOrderButton = By.xpath("//button[text()='Place Order']");
    By applyButton = By.xpath("//button[text()='Apply']");

    public void checkoutItems(){
        driver.findElement(cartIcon).click();
        driver.findElement(proceedToCheckoutButton).click();
    }

    public String getCartPageProductName() throws InterruptedException {

        Thread.sleep(3000);
        return driver.findElement(productNameInCartPage).getText();
    }

    public boolean verifyPromoButton () throws InterruptedException {
        Thread.sleep(3000);
        return driver.findElement(applyButton).isDisplayed();
    }

    public boolean verifyPlaceOrder () throws InterruptedException {
        Thread.sleep(3000);
        return driver.findElement(placeOrderButton).isDisplayed();
    }

    public void enterPromoCode(String productName) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(enterPromoCodeTextbox).sendKeys(productName);
    }
}
