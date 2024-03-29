package utils;

import jdk.jfr.Timespan;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public WebDriver driver;
    Properties properties;

    FileInputStream fis;
    public WebDriver WebDriverManager() throws IOException {

        properties= new Properties();
        fis= new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
        properties.load(fis);
        String url = properties.getProperty("QAUrl");
        String browser_properties = properties.getProperty("browser");
        String browser_maven = System.getProperty("browser");
        String browser = browser_maven!=null ? browser_maven:browser_properties;
        if (driver==null) {
            if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("test-type");
                options.addArguments("-disable-extensions");
                options.addArguments("--disable-gpu");
                options.addArguments("start-maximized");
                options.addArguments("force-device-scale-factor=1.20");
                options.addArguments("headless");
                this.driver = new ChromeDriver(options);
                this.driver.manage().window().maximize();

            } else if (browser.equalsIgnoreCase("firefox")){
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//src//test//resources//chromedriver.exe");
                driver = new FirefoxDriver();
            }

            driver.get(url);
        }
        return driver;
    }
}
