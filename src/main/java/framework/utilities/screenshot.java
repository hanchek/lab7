package framework.utilities;
import framework.Driver.Chrome;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class screenshot {
    private static int n = 1;
    public static void takeScreenshot() {
        Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(Chrome.getDriver());
        try {
            ImageIO.write(screenshot.getImage(), "PNG", new File("screenshot" + (n++) + ".png"));
        } catch (IOException e){
            e.printStackTrace();
        }

    }/*
    public static void takeScreenshot()
    {
        try {
            String targetUrl = Chrome.getDriver().getCurrentUrl();
            String targetImg= "screenshot" + (n++) + ".png";
            String command = "C:\\Users\\Ira\\IdeaProjects\\lab6\\phantomjs-2.1.1-windows\\bin\\phantomjs C:\\Users\\Ira\\IdeaProjects\\lab6\\phantomjs-2.1.1-windows\\examples\\rasterize.js "+targetUrl + " " +targetImg;
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/
}