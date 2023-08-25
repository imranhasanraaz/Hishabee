package utils;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class RobotUtils {

    public void uploadFile(String path) {
        try {
            Robot robot = new Robot();
            String filePath = new File(path).getAbsolutePath();
            StringSelection filepath = new StringSelection(filePath);
            robot.delay(3000);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
