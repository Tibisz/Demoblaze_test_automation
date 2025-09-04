package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.*;

import java.time.Duration;
import java.util.Map;

public class PurchaseSteps {
    private static WebDriver driver;
    private static HomePage homePage;
    private static LaptopsPage laptopsPage;
    private static ProductPage productPage;
    private static CartPage cartPage;
    private static PlaceOrderPage placeOrderPage;

    @Given("I am on the Demoblaze website")
    public void i_am_on_the_demoblaze_website() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.demoblaze.com/");
        homePage = new HomePage(driver);
        laptopsPage = new LaptopsPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        placeOrderPage = new PlaceOrderPage(driver);
    }

    @When("I select the Laptops category")
    public void i_select_the_laptops_category() {
        homePage.goToLaptops();
    }

    @When("I choose the product {string} with price {string}")
    public void i_choose_the_product_with_price(String productName, String price) {
        laptopsPage.selectMacbookAir();
    }

    @When("I add it to the cart")
    public void i_add_it_to_the_cart() {
        productPage.addToCart();
    }

    @When("I open the shopping cart")
    public void i_open_the_shopping_cart() {
        cartPage.openCart();
    }

    @Then("the product {string} should have the price {string}")
    public void the_product_should_have_the_price(String expectedTitle, String expectedPrice) {
        cartPage.verifyProduct(expectedTitle, expectedPrice);
    }

    @When("I place the order with the following details:")
    public void i_place_the_order_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);
        cartPage.clickPlaceOrder();
        placeOrderPage.fillFormAndPurchase(
                data.get("name"),
                data.get("country"),
                data.get("city"),
                data.get("credit card"),
                data.get("month"),
                data.get("year")
        );
        driver.quit();
    }
}
