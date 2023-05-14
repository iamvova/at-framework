package ui.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.wrapper.Decorator;

import static drivers.Driver.driver;

public class SetBioPage {

    @FindBy(xpath = "//button[contains(@class, 'js-profile-editable-edit-button')]")
    private WebElement chengeBioBtn;
    @FindBy(xpath = "//textarea[@class='form-control js-length-limited-input mb-1 width-full js-user-profile-bio-edit' and @id='user_profile_bio' and @name='user[profile_bio]' and @placeholder='Add a bio' and @aria-label='Add a bio' and @rows='3']")
    private WebElement changeBioInput;
    @FindBy(xpath = "//button[@data-target='waiting-form.submit' and @data-action='click:waiting-form#submitPolitely' and @type='submit' and @data-view-component='true' and @class='Button--primary Button--small Button d-inline-flex']")
    private WebElement confirmBioBtn;

    public SetBioPage(){
        PageFactory.initElements(new Decorator(driver), this);
    }


    public SetBioPage clickChangeBioBtn() throws InterruptedException {
        Thread.sleep(2000);
        chengeBioBtn.click();
        return this;
    }
    public SetBioPage changeBio(String bio) throws InterruptedException {
        Thread.sleep(1000);
        changeBioInput.sendKeys(bio);
        return this;
    }
    public SetBioPage confirmBio(){
        confirmBioBtn.click();
        return this;
    }

    public String checkBio(String bio) throws InterruptedException {
        Thread.sleep(1000);
        return bio;
    }



}