package ui.wrapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.Driver.driver;

public class Element {
    private static WebElement webElement;

    private static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public WebElement waitSomeSecond(){
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }
    public Element(WebElement webElement){
        this.webElement = webElement;
    }

    public WebElement getWebElement() {
        return webElement;
    }

    public void setWebElement(WebElement webElement) {
        this.webElement = webElement;
    }
}
