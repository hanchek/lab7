package framework.Elements;
import org.openqa.selenium.WebElement;


public class CheckBox extends Element {
    public CheckBox(WebElement element){
        super(element);
    }
    public void select() {
        if(!super.isSelected()) {
            click();
        }
    }
    public void cancel() {
        if(super.isSelected()) {
            click();
        }
    }
    @Override
    public void sendKeys(CharSequence... charSq) {return;}
    @Override
    public void submit(){return;}
}
