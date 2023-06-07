package desktop.wrapper;

import lombok.Data;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;

import java.io.File;

import static desktop.wrapper.ScreenHelper.screen;

@Data
public class PatternElement {
    private Pattern pattern = new Pattern();

    public PatternElement(String url) {
        pattern = new Pattern(new File("C:/Users/ME/IdeaProjects/at-framework/src/main/java/desktop/pattern_screen_shot/" + url).getAbsolutePath());
    }

    public Pattern getPatternAndWait() {
        try {
            screen.wait(pattern, 10000L).click();
        } catch (FindFailed e) {
            e.printStackTrace();
        }
        return pattern;
    }
}
