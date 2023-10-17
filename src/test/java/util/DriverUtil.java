package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverUtil {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver == null){
            System.out.println("NEW BROWSER");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeBrowser(){
        System.out.println("CLOSE BROWSER");
        driver.quit();
        driver = null;
    }

}
