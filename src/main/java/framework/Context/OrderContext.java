package framework.Context;
import framework.PageObjects.OrderPage;
import framework.PageObjects.FinalPage;


public class OrderContext {
    private OrderContext(){}
    public static FinalPage order(OrderPage page, String Name, String City,  String Phone, String email) throws InterruptedException {
        page.inputName(Name);
        page.inputCity(City);
        //Thread.sleep(1000);
        page.inputPhone(Phone);
        page.inputEmail(email);
        Thread.sleep(5000);
        return page.Continue();
    }
}
