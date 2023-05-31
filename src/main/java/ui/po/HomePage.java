package ui.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.wrapper.Decorator;
import ui.wrapper.Element;

import static drivers.Driver.driver;

public class HomePage {


    @FindBy(xpath = "//a[@href='/login' and contains(@class,'HeaderMenu-link--sign-in') and normalize-space()='Sign in']")
    private Element sigInBtn;
    public static final String URL = "https://github.com/";
    public HomePage(){
        PageFactory.initElements(new Decorator(driver), this);
        if (!URL.equals(driver.getCurrentUrl())){
            driver.get(URL);
        }

    }

    public LoginPage goToLoginPage()  {
        sigInBtn.waitSomeSecond().click();
        return new LoginPage();
    }
    public GoToRepoPage goToRepoPage() {
        return new GoToRepoPage();
    }
}
