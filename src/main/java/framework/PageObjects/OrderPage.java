package framework.PageObjects;

import framework.Driver.Chrome;
import framework.Elements.TextField;
import framework.Elements.Button;
import framework.Elements.Link;
import framework.utilities.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OrderPage extends Page{
    public OrderPage(){
        super();
    }
    @FindBy(xpath = "//*[@id='purchases_block']/div[1]/div[3]/a")
    private Link Cart;

    @FindBy(id = "reciever_name")
    private  TextField Name;

    @FindBy(id = "suggest_locality")
    private TextField City;

    @FindBy(id = "reciever_phone")
    private TextField Phone;

    @FindBy(id = "reciever_email")
    private TextField Email;

    @FindBy(xpath = "//*[@name = 'next_step']")
    private List<Button> continueButtons;

    public OrderPage inputName(String name){
        Name.input(name);
        return this;
    }
    public OrderPage inputCity(String city) throws InterruptedException{
        City.input(city);
        Thread.sleep(1000);
        List<WebElement> Cities = Chrome.getDriver().findElements(By.className("suggestion-i"));
        for(WebElement E : Cities) {
            System.out.println(E.getAttribute("text"));
        }
        for(WebElement E : Cities) {
            if(E.getAttribute("text").equals(city)) {
                E.click();
                return this;
            }
        }
        return this;
    }
    public OrderPage inputPhone(String phone) {
        Phone.input(phone);
        return this;
    }
    public OrderPage inputEmail(String email) {
        Email.input(email);
        return this;
    }
    public boolean isEnabled() {
        for(Button b : continueButtons){
            if(b.isEnabled()) return true;
        }
        return false;
    }
    public FinalPage Continue() {
        for(Button b : continueButtons){
            if(b.isEnabled()) b.click();
        }
        //Waiter.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath()))
        return new FinalPage();
    }
}
