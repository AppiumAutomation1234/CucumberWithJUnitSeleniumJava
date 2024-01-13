package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {

    LandingPage landingPage;
    TestContextSetup testContextSetup;

    public LandingPageStepDefinition(TestContextSetup testContextSetup){

        this.testContextSetup = testContextSetup;
    }

    @Given("User is on GreenCard landing page")
    public void user_is_on_green_card_landing_page() {

//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\arave\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
//        testContextSetup.driver = new ChromeDriver();
//        testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("^User searched with shortname as (.+) and extracted actual name of product$")
    public void user_searched_with_shortname_as_tom_and_extracted_actual_name_of_product(String productName) {
        landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.landingPageSearchItem(productName);
        //testContextSetup.driver.findElement(By.xpath("//input[@placeholder='Search for Vegetables and Fruits']")).sendKeys(productName);
        testContextSetup.landingPageProductName = landingPage.getLandingPageProductName().split("-")[0].trim();
        //testContextSetup.landingPageProductName = testContextSetup.driver.findElement(By.xpath("//div[@class='product']//*[@class='product-name']")).getText().split("-")[0].trim();
    }

    @And("^Added (.+) items of the selected product to cart$")
    public void addedItemsOfTheSelectedProductToCart(int number) throws InterruptedException {


        for(int i=0;i<number; i++){
            landingPage.incrementProductQuality();
        }

        landingPage.clickAddToCartButton();

    }
}
