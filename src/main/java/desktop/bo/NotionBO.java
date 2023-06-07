package desktop.bo;

import desktop.po.Notion;
import desktop.po.Window;
import org.sikuli.script.FindFailed;

public class NotionBO {
    private  Notion notion = new Notion();
    public void openNotion() throws FindFailed {
        Window window = new Window();
        window.openStart();
        window.openApp("Notion");
    }
    public void closeNotion() throws FindFailed {
        notion.close();
    }

    public void createList() throws FindFailed, InterruptedException {
        notion.createList();
    }

    public void addWidgetTask() throws FindFailed {
        notion.addTaskWidget();
    }
}
