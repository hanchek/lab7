package framework.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Chrome {
    private static WebDriver driver;
    private static Chrome chrome = new Chrome();
    Chrome(){}

    public static void initialize() {
       // ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ira\\IdeaProjects\\lab7\\chromedriver.exe");
        //options.addArguments("make-default-browser","disable-login-screen-apps","start-maximized");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver(){
        return driver;
    }
    public static void setDriver(WebDriver Driver){
        driver = Driver;
    }
}
