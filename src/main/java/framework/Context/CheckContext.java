package framework.Context;
import framework.PageObjects.FinalPage;
import framework.utilities.screenshot;

public class CheckContext {
    public  CheckContext(){}
    public static boolean Check(FinalPage page) {
        screenshot.takeScreenshot();
        return page.check();
    }
}
