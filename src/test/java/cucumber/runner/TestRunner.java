package cucumber.runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/cucumber/features",
        glue = "cucumber.stepDef",
        plugin = {"html:target/report.html"}
)
public class TestRunner {

    private static WebDriver driver;

//    @Before
//    void setUp(){
//        if(driver == null){
//            System.out.println("BEFORE ON RUNNER");
//            WebDriverManager.chromedriver().setup();
//
//            driver = new ChromeDriver();
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//            driver.manage().window().maximize();
//        }
//    }

//    @After
//    void teardown(){
//        System.out.println("TEARDOWN ON RUNNER");
//
//        driver.quit();
//        driver = null;
//    }

    public static WebDriver getDriver(){
        return driver;
    }


}
