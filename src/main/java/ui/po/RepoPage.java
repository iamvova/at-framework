package ui.po;

import org.openqa.selenium.support.PageFactory;
import ui.wrapper.Decorator;

import static drivers.Driver.driver;

public class RepoPage {
    public static final String URL = "https://github.com/vova-at?tab=repositories";
    public RepoPage(){
        PageFactory.initElements(new Decorator(driver), this);
        if (!URL.equals(driver.getCurrentUrl())){
            driver.get(URL);
        }
    }
    public SetBioPage goToBioPage() throws InterruptedException {
        Thread.sleep(1000);
        return new SetBioPage();
    }
}
