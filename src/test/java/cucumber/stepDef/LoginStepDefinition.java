package cucumber.stepDef;

import cucumber.runner.TestRunner;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.DriverUtil;

public class LoginStepDefinition {

    WebDriver driver = DriverUtil.getDriver();

    @After
    public void tearDown(){
        DriverUtil.closeBrowser();
    }

    String baseUrl = "https://saucedemo.com/";

    String standardUserUsername = "standard_user";
    String standardUserPassword = "secret_sauce";

    @Given("^user is on SwagLabs login page$")
    public void user_is_on_swaglabs_login_page(){
        driver.get(baseUrl);
    }

    @When("^user input (.*) as username$")
    public void user_input_value_as_username(String username){
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @And("^user input (.*) as password$")
    public void user_input_value_as_password(String password){
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("^user click login button$")
    public void user_click_login_button(){
        driver.findElement(By.id("login-button")).click();
    }

    @Then("^user verify (.*) login result$")
    public void user_verify_status_login_result(String status){
        String currentUrl = driver.getCurrentUrl();
        if(status.equals("success")){
            Assertions.assertEquals("https://www.saucedemo.com/inventory.html",currentUrl);
        }
        else {
            Assertions.assertEquals("https://www.saucedemo.com/",currentUrl);

            WebElement errorBox = driver.findElement(By.xpath("//div[@class='error-message-container error']"));
            Assertions.assertNotNull(errorBox);
        }
    }
    @Given("user login as standard_user")
    public void user_login_as_standard_user(){
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys(standardUserUsername);
        driver.findElement(By.id("password")).sendKeys(standardUserPassword);
        driver.findElement(By.id("login-button")).click();
    }

    @Given("^user on protected page (.*)$")
    public void user_on_protected_page(String page){
        driver.get(baseUrl + page + ".html");
    }

    @And("user get auth error message accessing (.*)$")
    public void user_get_auth_error_message(String page){
        String errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assertions.assertEquals("Epic sadface: You can only access '/" + page + ".html' when you are logged in.",errorMessage);
    }

    @Then("user is redirected to SwagLabs login page")
    public void user_is_redirected_to_swaglabs_login_page(){
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://www.saucedemo.com/",currentUrl);
    }

//    @After
//    public void tearDown(){
//        System.out.println("TEARDOWN LOGIN");
//        driver.quit();
//        driver.close();
//        driver = null;
//    }

}
