package framework.PageObjects;

import framework.Elements.Button;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends Page {
    @FindBy(xpath = "//*[@class='toOrder']")
    private Button Purchase;
    public CartPage addToCart() throws InterruptedException{
        Purchase.click();
        Thread.sleep(2000);
        return  new CartPage();
    }
    public ItemPage(){
        super();
    }

}
