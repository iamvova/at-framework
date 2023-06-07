package desktop.po;

import desktop.wrapper.PatternElement;
import org.sikuli.script.FindFailed;

import static desktop.wrapper.ScreenHelper.screen;

public class Notion {
    private PatternElement close = new PatternElement("close_app.png");
    private PatternElement newPageButton = new PatternElement("add_page.png");
    private PatternElement templates = new PatternElement("templates.png");
    private PatternElement getTemplates = new PatternElement("get_templates.png");
    public void  close() throws FindFailed {
        screen.find(close.getPatternAndWait()).click();
    }

    public void createList() throws FindFailed, InterruptedException {
        Thread.sleep(3000);
        screen.find(newPageButton.getPatternAndWait()).click();
    }

    public void addTaskWidget() throws FindFailed {
        screen.find(newPageButton.getPatternAndWait()).click();
        screen.find(templates.getPatternAndWait()).click();
        screen.find(getTemplates.getPatternAndWait()).click();
    }
}
