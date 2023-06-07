package desktop;

import desktop.bo.NotionBO;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

public class CreateListTest {
    private NotionBO notionBO = new NotionBO();
    @Test
    public void createNewListTest() throws FindFailed, InterruptedException {
        notionBO.openNotion();
        notionBO.createList();
        notionBO.closeNotion();
    }
}
