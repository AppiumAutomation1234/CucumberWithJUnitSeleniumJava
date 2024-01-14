package utils;

import org.junit.Assert;
import org.junit.rules.Timeout;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.DateTimeException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class GenericUtils {

    public WebDriver driver;
    JavascriptExecutor javascriptExecutor;
    WebDriverWait wait;
    public GenericUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void switchWindowToChild() {
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
        driver.switchTo().window(childWindow);
    }

    public String randomNumber(int length) {

        try {
            String s = " ";
            Random random = new Random();
            for (int i = 0; i <= length; i++) {
                s = randomNumber(length).toString();
            }
            return s;
        } catch (Exception e) {
            e.printStackTrace();
            return " ";
        }
    }

    public void javaScrollToElement(By by) {
        try {
            ((JavascriptExecutor) this.driver).executeScript("arguments[0].scrollIntoView(true);", this.driver.findElement(by));
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void scrollToElement(WebElement element) {

        try {
            Actions actions = new Actions(this.driver);
            actions.moveToElement(element);
            actions.build().perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean elementUnAvailability(By by, String msg) {

        try {
            List<WebElement> elements = this.driver.findElements(by);
            if (elements.stream().count() == 0) {
                System.out.println(msg + " is not Available");
                return true;
            } else {
                System.out.println(msg + " is Available");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void cleanUp() {

        try {
            if (this.driver != null) {
                this.driver.quit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void launchURL(String url) {
        try {
            this.driver.navigate().to(url);
            System.out.println("Application url is: " + url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void elementOperations(String action, By by, String value, String report) {

        try {
            Thread.sleep(500);
            WebElement element = this.driver.findElement(by);
            this.javaScrollToElement(by);
            switch (action) {
                case "click":
                    try {

                        javascriptExecutor = (JavascriptExecutor) this.driver;
                        javascriptExecutor.executeScript("arguments[0].click();", element);
                    } catch (Exception e) {
                        element.click();
                    }
                    System.out.println(report + " is clicked");
                    break;

                case "sendKeys":
                    try {
                        element.clear();
                        element.sendKeys(value);
                        System.out.println(report + " is send as input");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case "verify":
                    try {
                        if (element.isDisplayed()) {
                            System.out.println(element.getText() + " is displayed");
                        } else {
                            System.out.println(element.getText() + " is not displayed");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case "selected":
                    try {
                        if (element.isSelected()) {
                            System.out.println(element.getText() + " is selected/checked");
                        } else {
                            System.out.println(element.getText() + " is not selected/checked");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case "enabled":
                    try {
                        if (element.isEnabled()) {
                            System.out.println(element.getText() + " is enabled");
                        } else {
                            System.out.println(element.getText() + " is not enabled");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new ArithmeticException("Person is not eligible to vote");
        }
    }

    public void waitUntilElementLocated(By by) {
        try {

            Thread.sleep(500);
            wait = new WebDriverWait(this.driver, Duration.ofSeconds(5000));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilAlertPresent() {
        try {

            Thread.sleep(500);
            wait = new WebDriverWait(this.driver, Duration.ofSeconds(5000));
            wait.until(ExpectedConditions.alertIsPresent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementToBeClickable(By by) {
        try {

            Thread.sleep(500);
            wait = new WebDriverWait(this.driver, Duration.ofSeconds(5000));
            wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilFrameToBeAvailableAndSwitchToIt(By by) {
        try {

            Thread.sleep(500);
            wait = new WebDriverWait(this.driver, Duration.ofSeconds(5000));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilInvisibilityOfTheElementLocated(By by) {
        try {

            Thread.sleep(500);
            wait = new WebDriverWait(this.driver, Duration.ofSeconds(5000));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilInvisibilityOfElementWithText(By by, String value) {
        try {

            Thread.sleep(500);
            wait = new WebDriverWait(this.driver, Duration.ofSeconds(5000));
            wait.until(ExpectedConditions.invisibilityOfElementWithText(by, value));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilPresenceOfElementLocated(By by) {
        try {

            Thread.sleep(500);
            wait = new WebDriverWait(this.driver, Duration.ofSeconds(5000));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean stringAvailabilityInStringArray(String[] colValues, String searchValue) {
        try {
            for (int i = 0; i <= colValues.length; i++) {
                if (colValues[i].trim().equals(searchValue)) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkButtonsIsClickable(By by) {
        try {
            Thread.sleep(500);
            WebElement button = this.driver.findElement(by);
            System.out.println("Locator: " + button + button.isEnabled() + button.getText().trim());
            return button.isDisplayed() && button.isSelected() && button.isEnabled();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void selectByVisibleText(By by, String text) {
        try {
            Thread.sleep(800);
            Select select = new Select(driver.findElement(by));
            select.selectByVisibleText(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectByIndex(By by, int args) {
        try {
            Thread.sleep(800);
            Select select = new Select(driver.findElement(by));
            select.selectByIndex(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectByValue(By by, String value) {
        try {
            Thread.sleep(800);
            Select select = new Select(driver.findElement(by));
            select.selectByValue(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<WebElement> returnSelectedWebElements(By by) {
        List<WebElement> webElements = null;
        try {
            Thread.sleep(500);
            Select select = new Select(this.driver.findElement(by));
            webElements = select.getOptions();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return webElements;
    }

    public void elementAvailability(By by) {
        try {

            WebElement element = this.driver.findElement(by);
            if (element.isDisplayed()) {
                System.out.println(element.getText() + "is displayed");
            } else {
                System.out.println(element.getText() + "is not displayed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean compareToString(String actual, String expected) {
        try {

            Assert.assertEquals(actual, expected);
            System.out.println(actual + "And" + expected + "values are equal");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean validateActualAndExpectedValues(String actual, String expected) {
        try {
            if (actual.toLowerCase().contains(expected.toLowerCase())) {
                System.out.println(actual + "And" + expected + "values are matched");
                return true;
            } else {
                System.out.println(actual + "And" + expected + "values are not matched");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String returnStringValue(By by) {
        this.javaScrollToElement(by);
        String eleText = this.driver.findElement(by).getText().trim();
        System.out.println("Text Attribute for locator is: " + eleText);
        return eleText;
    }

    public String getElementText(By by) {
        return this.driver.findElement(by).getText();
    }

    public String returnAttributeValue(By by, String attr) {
        this.javaScrollToElement(by);
        return this.driver.findElement(by).getAttribute(attr).trim();
    }

    public List<WebElement> returnListOfWebElements(By by) {
        List<WebElement> webElements = this.driver.findElements(by);
        return webElements;
    }

    public void clickElementByJavaScript(By by){
        WebElement element = this.driver.findElement(by);
        javascriptExecutor = (JavascriptExecutor)this.driver;
        javascriptExecutor.executeScript("arguments[0].click();", by);
    }

    public void waitForAjax() {
        new WebDriverWait(this.driver, Duration.ofSeconds(3000)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                return (Boolean) js.executeScript("return jQuery.active == 0");
            }
        });
    }
    public void refresh(){
        this.driver.navigate().refresh();
    }

    public void sendTabKeyOnElement(By by){
        WebElement element=this.driver.findElement(by);
        element.sendKeys(Keys.TAB);
    }

    public void sendEnterKeyOnElement(By by){
        WebElement element=this.driver.findElement(by);
        element.sendKeys(Keys.DOWN);
        element.sendKeys(Keys.ENTER);
    }

    public boolean isCheckedBoxSelected(By by){
        WebElement element = this.driver.findElement(by);
        return element.isSelected();
    }

    public boolean isElementIsEnabled(By by){
        WebElement element = this.driver.findElement(by);
        return element.isEnabled();
    }

    public int countElements(By by) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> elements = this.driver.findElements(by);
        return elements.size();

    }

    public void zoomIn(){
        this.zoomIn();
    }


}
