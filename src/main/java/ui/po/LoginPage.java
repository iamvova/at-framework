package ui.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.wrapper.Decorator;
import static drivers.Driver.driver;
public class LoginPage {
    @FindBy(id = "login_field")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(className = "js-sign-in-button")
    private WebElement btnSignIn;

    @FindBy(className = "avatar-small")
    private WebElement avatarSmall;
    @FindBy(className = "css-truncate-target")
    private WebElement checkName;

    public LoginPage() {
        PageFactory.initElements(new Decorator(driver), this);
    }

    public LoginPage inputLogin(String login) throws InterruptedException {
        Thread.sleep(1000);
        loginField.sendKeys(login);
        return this;
    }

    public LoginPage inputPassword(String pass) {
        passwordField.sendKeys(pass);
        return this;
    }

    public LoginPage login() {
        btnSignIn.click();
        return this;
    }

    public LoginPage clickOnAvatar() throws InterruptedException {
        Thread.sleep(2000);
        avatarSmall.click();
        return this;
    }

    public String checkName() throws InterruptedException {
        Thread.sleep(1000);
        return checkName.getText();
    }


}