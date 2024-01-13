package utils;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class GenericUtils {

    public WebDriver driver;
    public GenericUtils(WebDriver driver){
        this.driver = driver;
    }
    public void switchWindowToChild(){
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();

        driver.switchTo().window(childWindow);
    }
}
