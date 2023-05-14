package ui.bo;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ui.po.RepoPage;
import ui.wrapper.Decorator;

import static drivers.Driver.driver;

public class BioStatus {
    private String bio = "This is my new bio.";
    RepoPage repoPage;

    public BioStatus() {
        PageFactory.initElements(new Decorator(driver), this);
    }

    public BioStatus checkBioUser(){
        repoPage = new RepoPage();
        return this;
    }

    public void nameBioUser() throws InterruptedException {
        String userLabel = repoPage.goToBioPage()
                .clickChangeBioBtn()
                .changeBio(bio)
                .confirmBio()
                .checkBio(bio);

        Assert.assertEquals(userLabel, bio);
    }
}
