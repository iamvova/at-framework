package ui.bo;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ui.po.HomePage;
import ui.po.LoginPage;
import ui.wrapper.Decorator;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static drivers.Driver.driver;

public class Login {
    private Properties properties = new Properties();
    LoginPage loginPage;
    HomePage homePage;



    public Login() throws IOException {
        properties.load(new FileReader("src/main/resources/application.properties"));
        PageFactory.initElements(new Decorator(driver), this);
    }

    public Login checkLoginUser(){
        homePage = new HomePage();
        return this;
    }

    public void loginUser() throws InterruptedException {
        String login = properties.getProperty("LOGIN");
        String pass = properties.getProperty("PASS");
        String userLabel = homePage.goToLoginPage()
                .inputLogin(login)
                .inputPassword(pass)
                .login()
                .clickOnAvatar()
                .checkName();

        Assert.assertEquals(userLabel, login);
    }
}
