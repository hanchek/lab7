package framework.PageObjects;

import framework.Elements.Button;
import framework.Elements.Link;
import framework.Elements.TextField;
import framework.utilities.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPage extends Page{
    @FindBy(id = "price[min]")
    private TextField minPrice;

    @FindBy(id = "price[max]")
    private TextField maxPrice;

    @FindBy(id = "submitprice")
    private Button OK;

    @FindBy(xpath = "//*[@id='sort_strana-vino']/descendant::a")
    private List<Link> Countries;

    @FindBy(xpath = "//*[@id=\"filter_parameters_form\"]/div[8]/div[2]/a[1]")
    private Link moreCountries;

    @FindBy(xpath = "//*[@id=\\\"catalog_goods_block\\\"]/div/div/div[1]/div/div/div/div/div/descendant::button")
    private List<Button> buyButtons;

    @FindBy(xpath = "//*[@class='g-i-tile-i-box-desc']/div[2]/a")
    private List<Link> Goods;

    public MainPage() {
        super();
    }
    public MainPage setMinPrice(int price) {
        minPrice.clear();
        minPrice.sendKeys(Integer.toString(price));
        System.out.println("Set min price");
        return this;
    }
    public MainPage setMaxPrice(int price) {
        maxPrice.clear();
        maxPrice.sendKeys(Integer.toString(price));
        System.out.println("Set max price");
        return this;
    }
    public MainPage setCountry(String country) {
        moreCountries.follow();
        System.out.println("Followed more countries");
        //Waiter.wait.until(o->{return ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='filter_parameters_form']/div[8]/div[2]")); });
        Waiter.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='filter_parameters_form']/div[8]/div[2]")));
        for(Link link : Countries) {
            if (link.findElement(By.xpath("span/i")).getText().equals(country)) {
                System.out.println("Chose country");
                link.follow();
                break;
            }
        }
        return this;
    }
    public ItemPage selectGoodFromGoods(String name){
        for(Link link : Goods){
            System.out.println(link.getText());
            if(link.getText().equals(name)) {
                link.follow();
                break;
            }
        }
        return new ItemPage();
    }
    public MainPage adjustPriceFilter(){
        Waiter.wait.until(ExpectedConditions.elementToBeClickable(OK));
        OK.click();
        System.out.println("Adjusted price filter");
        return  this;
    }

}
