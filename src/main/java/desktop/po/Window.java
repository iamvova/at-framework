package desktop.po;

import desktop.wrapper.PatternElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;

import static desktop.wrapper.ScreenHelper.screen;

public class Window {
    private PatternElement startScreen = new PatternElement("start.png");
    private PatternElement inputStart = new PatternElement("search_input_start.png");
    public void openStart() throws FindFailed {
        screen.find(startScreen.getPattern()).click();
    }
    public void openApp(String nameApp) throws FindFailed {
        screen.find(inputStart.getPatternAndWait()).click();
        screen.type(nameApp);
        screen.type(Key.ENTER);
    }
}
