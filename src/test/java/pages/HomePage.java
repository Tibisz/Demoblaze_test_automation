package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By laptopsCategory = By.linkText("Laptops");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToLaptops() {
        driver.findElement(laptopsCategory).click();
    }
}
