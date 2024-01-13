package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckOutPageStepDefinitaions {

    CheckoutPage checkoutPage;
    TestContextSetup testContextSetup;

    public CheckOutPageStepDefinitaions(TestContextSetup testContextSetup){

        this.testContextSetup = testContextSetup;
    }

    @Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
    public void userProceedsToCheckoutAndValidateTheNameItemsInCheckoutPage(String productName) throws InterruptedException {
        checkoutPage=testContextSetup.pageObjectManager.getCheckoutPage();
        checkoutPage.checkoutItems();
        testContextSetup.landingPageProductName = checkoutPage.getCartPageProductName().split("-")[0].trim();
        Assert.assertEquals(productName, testContextSetup.landingPageProductName);
    }

    @And("Verify user has ability to enter the promo code and place the order")
    public void verifyUserHasAbilityToEnterThePromoCodeAndPlaceTheOrder() throws InterruptedException {

        boolean test1 = checkoutPage.verifyPromoButton();
        Assert.assertTrue(test1);
        boolean test2 = checkoutPage.verifyPlaceOrder();
        Assert.assertTrue(test2);
        checkoutPage.enterPromoCode("XYZ");
    }
}
