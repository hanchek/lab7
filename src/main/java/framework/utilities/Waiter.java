package framework.utilities;

import framework.Driver.Chrome;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class Waiter {
    public static final FluentWait wait=new FluentWait(Chrome.getDriver());
    {
        wait.withTimeout(Duration.ofMillis(5000));
        wait.ignoring(NoSuchElementException.class);
    }
}