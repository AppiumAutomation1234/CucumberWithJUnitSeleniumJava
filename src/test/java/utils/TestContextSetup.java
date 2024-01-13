package utils;

import org.openqa.selenium.WebDriver;
import pageObjects.PageObjectManager;

import java.io.IOException;

public class TestContextSetup {

    public WebDriver driver;
    public String landingPageProductName;
    public String offerPageProductName;
    public String cartPageProductName;

    public TestBase testBase;
    public PageObjectManager pageObjectManager;

    public GenericUtils genericUtils;

    public TestContextSetup() throws IOException {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
        genericUtils = new GenericUtils(testBase.WebDriverManager());
    }


}
