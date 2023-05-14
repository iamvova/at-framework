package drivers;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    public static WebDriver driver;
    public static void setup(){
        ChromeDriverManager.getInstance().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }
    public static void closeBrowser(){
            driver.close();
            driver.quit();
    }

    public static void setDriver(WebDriver driver) {
        Driver.driver = driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
