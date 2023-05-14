package ui;

import drivers.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.bo.BioStatus;

public class SetBioTest {
    private WebDriver driver;
    @BeforeTest
    void setup(){
        Driver.setup();
    }
//    void setup() {
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
//    }
    @Test
    void endToEndTest() throws InterruptedException {
        BioStatus setStatus = new BioStatus();
        setStatus.checkBioUser().nameBioUser();
    }
    @AfterTest
    void closeBrowser(){
        Driver.closeBrowser();
    }
}
