package framework.PageObjects;

import framework.Elements.TextField;
import framework.Elements.Button;
import framework.Elements.CheckBox;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class FinalPage extends Page{
    public FinalPage(){
        super();
    }
    @FindBy(id= "make-order")
    private Button Order;

    public boolean check() {
        return(Order.isEnabled());
    }
}
