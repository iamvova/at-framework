package ui.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.wrapper.Decorator;
import ui.wrapper.Element;
import static drivers.Driver.driver;
public class LoginPage {
    @FindBy(id = "login_field")
    private Element loginField;

    @FindBy(id = "password")
    private Element passwordField;

    @FindBy(className = "js-sign-in-button")
    private Element btnSignIn;

    @FindBy(className = "avatar-small")
    private Element avatarSmall;
    @FindBy(className = "css-truncate-target")
    private Element checkName;

    public LoginPage() {
        PageFactory.initElements(new Decorator(driver), this);
    }

    public LoginPage inputLogin(String login){
        loginField.waitSomeSecond().sendKeys(login);
        return this;
    }

    public LoginPage inputPassword(String pass) {
        passwordField.getWebElement().sendKeys(pass);
        return this;
    }

    public LoginPage login() {
        btnSignIn.getWebElement().click();
        return this;
    }

    public LoginPage clickOnAvatar(){
        avatarSmall.waitSomeSecond().click();
        return this;
    }

    public String checkName(){
        return checkName.waitSomeSecond().getText();
    }


}