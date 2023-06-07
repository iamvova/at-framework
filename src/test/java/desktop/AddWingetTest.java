package desktop;

import desktop.bo.NotionBO;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

public class AddWingetTest {
    private NotionBO notionBO = new NotionBO();
    @Test
    public void addWidgetPageTest() throws FindFailed {
        notionBO.openNotion();
        notionBO.addWidgetTask();
        notionBO.closeNotion();
    }
}
