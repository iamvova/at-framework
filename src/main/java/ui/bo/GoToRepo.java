package ui.bo;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ui.po.HomePage;
import ui.wrapper.Decorator;

import static drivers.Driver.driver;

public class GoToRepo {

    HomePage homePage;

    String login = "vova-at";

    public GoToRepo() {
        PageFactory.initElements(new Decorator(driver), this);
    }

    public GoToRepo checkRepoUser(){
        homePage = new HomePage();
        return this;
    }

    public void nameInRepoUser() throws InterruptedException {
        String userLabel = homePage.goToRepoPage()
                .clickMyRepoBtn()
                .checkNameInRepo();

        Assert.assertEquals(userLabel, login);
    }
}
