package framework.Elements;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;

public class TextField extends Element {
    public TextField(WebElement element) {
        super(element);
    }
    public void clear(){
        sendKeys(Keys.CONTROL + "a");
        sendKeys(Keys.DELETE);
    }
    public void input(String s) {
        clear();
        sendKeys(s);
    }
}
