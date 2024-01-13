package stepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pageObjects.OfferPage;
import utils.TestContextSetup;

public class OfferPageStepDefinition {

    TestContextSetup testContextSetup;

    public OfferPageStepDefinition(TestContextSetup testContextSetup) {

        this.testContextSetup = testContextSetup;
    }
    OfferPage offerPage;

    @Then("^user searched for (.+) same shortname in offers page to check if product exist with same name$")
    public void user_searched_for_tom_same_shortname_in_offers_page_to_check_if_product_exist_with_same_name(String productName) {
        offerPage = testContextSetup.pageObjectManager.getOfferPage();
        offerPage.clickOnDealsLink();
        //testContextSetup.driver.findElement(By.xpath("//a[text()='Top Deals']")).click();

        testContextSetup.genericUtils.switchWindowToChild();

        offerPage.offerPageSearchItem(productName);
        //testContextSetup.driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(productName);

        testContextSetup.offerPageProductName = offerPage.getOfferPageProductName();
        //testContextSetup.offerPageProductName = testContextSetup.driver.findElement(By.xpath("//tr//td[1]")).getText();
        Assert.assertEquals(testContextSetup.landingPageProductName, testContextSetup.offerPageProductName);
    }



}
