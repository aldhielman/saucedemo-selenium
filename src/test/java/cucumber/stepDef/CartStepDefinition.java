package cucumber.stepDef;

import cucumber.runner.TestRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import util.DriverUtil;

import java.time.Duration;
import java.util.List;

public class CartStepDefinition {

    WebDriver driver = DriverUtil.getDriver();

    String baseUrl = "https://saucedemo.com/";

    @Given("user on cart page")
    public void user_on_inventory_page(String page){
        driver.get(baseUrl + "cart.html");
    }

    @Given("cart item is empty")
    public void cart_item_is_empty(){
        WebElement cartIconElement = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        String child = cartIconElement.getText();
        Assertions.assertEquals("",child);
    }

    @When("user click 'add to cart' button on item")
    public void user_click_add_to_cart_button_on_item(){
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @Then("cart icon have 1 item")
    public void cart_icon_will_have_1_item(){
        String countText =  driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
        int cartItemCount = Integer.parseInt(countText);
        Assertions.assertEquals(1,cartItemCount);

    }

    @When("user click remove button on added item")
    public void user_click_remove_button_on_added_item(){
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
    }

    @And("cart page have no item")
    public void cart_page_have_no_item(){
        driver.get(baseUrl + "cart.html");
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='cart_item']"));
        Assertions.assertEquals(0,elements.size());

    }

}
