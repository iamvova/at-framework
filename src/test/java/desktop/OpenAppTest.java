package desktop;

import desktop.bo.NotionBO;
import desktop.po.Window;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

public class OpenAppTest {
    private NotionBO notionBO = new NotionBO();
    @Test
    void openApplicationTest() throws FindFailed {
        notionBO.openNotion();
        notionBO.closeNotion();
    }
}
