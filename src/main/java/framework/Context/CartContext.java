package framework.Context;

import framework.PageObjects.CartPage;
import framework.PageObjects.ItemPage;
import framework.PageObjects.OrderPage;

public class CartContext {
    private CartContext(){}
    private static OrderPage MakeOrder(CartPage page){
        return page.purchase();
    }
    public static OrderPage Order(ItemPage page) throws InterruptedException {
        Thread.sleep(2000);
        CartPage p = page.addToCart();
        return MakeOrder(p);
    }
}
