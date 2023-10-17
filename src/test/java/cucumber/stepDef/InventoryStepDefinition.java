package cucumber.stepDef;

import cucumber.runner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.DriverUtil;

public class InventoryStepDefinition {
    WebDriver driver = DriverUtil.getDriver();

    String baseUrl = "https://saucedemo.com/";

    @Given("user on inventory page")
    public void user_on_inventory_page(){
        driver.get(baseUrl + "inventory.html");
    }

    @Given("user click link in product title")
    public void user_click_link_in_product_title(){
        driver.findElement(By.id("item_4_title_link")).click();
    }

    @Then("user on inventory-item page")
    public void user_on_inventory_item_page(){
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://www.saucedemo.com/inventory-item.html?id=4",currentUrl);
    }

    @When("user change id parameter in url with invalid inventory ID")
    public void user_change_id_parameter_in_url_with_invalid_inventory_id(){
        driver.get("https://www.saucedemo.com/inventory-item.html?id=xxx");
    }

    @Then("user get info that item is not found")
    public void user_get_info_that_item_is_not_found(){
        String inventoryName = driver.findElement(By.className("inventory_details_name")).getText();
        Assertions.assertEquals("ITEM NOT FOUND",inventoryName);
    }

    @Then("user get correct inventory-item page")
    public void user_get_correct_inventory_item_page() {
        String title = driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText();
        Assertions.assertEquals("Sauce Labs Backpack",title);
    }

}
