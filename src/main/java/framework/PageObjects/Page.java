package framework.PageObjects;
import framework.Driver.Chrome;
import framework.utilities.FieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class Page {
    public Page(){
        PageFactory.initElements(new FieldDecorator(Chrome.getDriver()), this);
    }


}