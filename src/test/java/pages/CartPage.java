package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartPage extends BasePage {
    private By cartLink = By.linkText("Cart");
    private By productTitle = By.xpath("//td[2]");
    private By productPrice = By.xpath("//td[3]");
    private By placeOrderBtn = By.xpath("//button[text()='Place Order']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openCart() {
        driver.findElement(cartLink).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
    }

    public void verifyProduct(String expectedTitle, String expectedPrice) {
        String actualTitle = driver.findElement(productTitle).getText();
        String actualPrice = driver.findElement(productPrice).getText();
        assertEquals(expectedTitle, actualTitle, "Product title does not match!");
        assertEquals(expectedPrice, actualPrice, "Product price does not match!");
    }

    public void clickPlaceOrder() {
        driver.findElement(placeOrderBtn).click();
    }
}
