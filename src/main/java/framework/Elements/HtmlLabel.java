package framework.Elements;
import org.openqa.selenium.WebElement;

public class HtmlLabel extends Element{
    public HtmlLabel(WebElement element) {
        super(element);
    }
    public String getTextOfLabel(){
        return super.getText();
    }
}
