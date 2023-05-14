package ui;

import allure.AllureListener;
import drivers.Driver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.bo.GoToRepo;
import ui.bo.Login;
import ui.bo.BioStatus;

import java.io.IOException;

@Listeners({AllureListener.class})
public class LoginTest {
    @BeforeTest
    void setup(){
        Driver.setup();
    }
//    void setup() {
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
//    }
    @Test
    void endToEndTest() throws InterruptedException, IOException {
        Login loginBO = new Login();
        loginBO.checkLoginUser().loginUser();

        GoToRepo goToRepoBO = new GoToRepo();
        goToRepoBO.checkRepoUser().nameInRepoUser();
        Thread.sleep(2000);
        BioStatus setStatus = new BioStatus();

        Thread.sleep(2000);
        setStatus.checkBioUser().nameBioUser();

    }
    @AfterTest
    void closeBrowser(){
        Driver.closeBrowser();
    }
}
