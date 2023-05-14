package ui;

import drivers.Driver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.bo.GoToRepo;

public class GoToRepoTest {
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
        GoToRepo goToRepoBO = new GoToRepo();

        goToRepoBO.checkRepoUser().nameInRepoUser();
    }
    @AfterTest
    void closeBrowser(){
        Driver.closeBrowser();
    }
}
