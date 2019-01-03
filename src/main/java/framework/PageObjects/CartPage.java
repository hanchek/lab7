package framework.PageObjects;

import framework.Driver.Chrome;
import framework.Elements.TextField;
import framework.Elements.Button;
import framework.utilities.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends Page {
    @FindBy(xpath = "//*[@class='cart-amount']/input")
    private TextField Amount;

    @FindBy(id = "popup-checkout")
    private Button Purchase;

    public OrderPage purchase(){
        Amount.clear();
        Amount.input("10");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean flag = true;
        while(flag) {
            flag = false;
            try{
                WebElement w = Chrome.getDriver().findElement(By.id("reciever_name"));
            }catch (NoSuchElementException e) {
                Purchase.click();
                flag = true;
            }
        }
        //Waiter.wait.until(o->{return ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class = 'check-wrap']")); });
        Waiter.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class = 'check-wrap']")));
        return new OrderPage();
    }
    public CartPage(){
        super();
    }
}
