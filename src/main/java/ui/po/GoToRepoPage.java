package ui.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.wrapper.Decorator;
import ui.wrapper.Element;

import static drivers.Driver.driver;

public class GoToRepoPage {
    @FindBy(xpath = "//a[@href='/vova-at?tab=repositories']")
    private Element myRepoBtn;
    @FindBy(xpath = "//span[@class='p-nickname vcard-username d-block']")
    private Element getTextInRepo;

    public GoToRepoPage(){
        PageFactory.initElements(new Decorator(driver), this);
    }


    public GoToRepoPage clickMyRepoBtn(){
        myRepoBtn.getWebElement().click();
        return this;
    }
    public String checkNameInRepo() {
         return getTextInRepo.waitSomeSecond().getText();
    }



}