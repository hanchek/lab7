package framework.Elements;
import org.openqa.selenium.*;

import java.util.List;

public class Element implements WebElement{
    private WebElement element;
    protected Element(WebElement element) {
        this.element = element;
    }
    protected WebElement getElement() { return this.element; }
    protected void setElement(WebElement element) { this.element = element; }
    //Method Summary seleniumhq.github.io
    public void clear() { element.clear(); }
    public void click() { element.click(); }
    public WebElement findElement(By by) { return element.findElement(by); }
    public List<WebElement> findElements(By by) { return element.findElements(by); }
    public String getAttribute(String s) { return element.getAttribute(s); }
    public String getCssValue(String s) { return element.getCssValue(s); }
    public Point getLocation() { return element.getLocation(); }
    public Rectangle getRect() { return element.getRect(); }
    public Dimension getSize() { return element.getSize(); }
    public String getTagName() { return element.getTagName(); }
    public String getText() { return element.getText(); }
    public boolean isDisplayed() { return element.isDisplayed(); }
    public boolean isEnabled() { return element.isEnabled(); }
    public boolean isSelected() {  return element.isSelected(); }
    public void sendKeys(CharSequence... charSq) { element.sendKeys(charSq); }
    public void submit() { element.submit(); }
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException { return element.getScreenshotAs(outputType); }
}
