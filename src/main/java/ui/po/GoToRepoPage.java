package ui.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.wrapper.Decorator;

import static drivers.Driver.driver;

public class GoToRepoPage {
    @FindBy(xpath = "//a[@href='/vova-at?tab=repositories']")
    private WebElement myRepoBtn;
    @FindBy(xpath = "//span[@class='p-nickname vcard-username d-block']")
    private WebElement getTextInRepo;

    public GoToRepoPage(){
        PageFactory.initElements(new Decorator(driver), this);
    }


    public GoToRepoPage clickMyRepoBtn() throws InterruptedException {
        myRepoBtn.click();
        return this;
    }
    public String checkNameInRepo() throws InterruptedException {
        Thread.sleep(1000);
         return getTextInRepo.getText();
    }



}