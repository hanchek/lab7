package framework.Elements;

import org.openqa.selenium.WebElement;


public class Button extends Element{
    public Button(WebElement element) {
        super(element);
    }
    @Override
    public void click() {
        if (super.isDisplayed() && super.getSize().height > 0 && super.getSize().width > 0 && super.isEnabled())
            super.click();
    }
    @Override
    public void submit() {
        return;
    }
    @Override
    public void sendKeys(CharSequence... sequences) {
        return;
    }
    @Override
    public void clear() {
        return;
    }
    @Override
    public boolean isSelected() {
        return false;
    }
}
