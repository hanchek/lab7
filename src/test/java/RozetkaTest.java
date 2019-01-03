import framework.Context.*;
import framework.Driver.Chrome;
import framework.PageObjects.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.FluentWait;

//import java.time.Duration;

import static org.junit.Assert.fail;

public class RozetkaTest {
    private static String baseUrl = "https://rozetka.com.ua/shampanskoe-i-igristoe-vino/c4649058/";
   // private static String baseUrl = "https://rozetka.com.ua/artwine_4820176061928/p66568110/";
    private StringBuffer RozetkaErrors = new StringBuffer();

    @Before
    public void setUpTest() throws Exception {
        Chrome.initialize();
        //FluentWait wait=new FluentWait(Chrome.getDriver());
        //wait.withTimeout(Duration.ofMillis(5000));
        //wait.pollingEvery(Duration.ofMillis(500));
    }

    @Test
    public void testRozetka() throws Throwable {
        try {
            Chrome.getDriver().navigate().to(baseUrl);
            ItemPage I = MainContext.ChooseItem(new MainPage(), "Вино игристое Artwine розовое брют 0.75 л 10-13.5% (4820176061928)","Украина", 200, 500);
            OrderPage O = CartContext.Order(I);
            FinalPage P = OrderContext.order(O, "Ivanov Myhailo", "Киев", "0999806585", "djghdskghjdshebwh@gmail.com");
            if(CheckContext.Check(P)) {
                System.out.println("Hurray!");
            }
            //if(CheckContext.Check(OrderContext.order(CartContext.Order(MainContext.ChooseItem(new MainPage(), "Вино игристое Maison Bouey Cuvee Royale белое брют 0.75 л 12% (3504300000038)", "Украина", 200, 500)), "Иванов Михаил", "0999806585", "iv09mik@gmail.com")))
            Thread.sleep(20000);
        }
        catch (Exception e){
            RozetkaErrors.append("Something went wrong...");
            e.printStackTrace();}
    }
    @After
    public void tearDown() throws Exception {
        Chrome.getDriver().quit();
        String RozetkaErrorString = RozetkaErrors.toString();
        if (!"".equals(RozetkaErrors.toString())) {
            fail(RozetkaErrorString);
        }
    }
}
