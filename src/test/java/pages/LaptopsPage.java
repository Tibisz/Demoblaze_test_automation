package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LaptopsPage extends BasePage {
    private By macbookAirLink = By.linkText("MacBook air");

    public LaptopsPage(WebDriver driver) {
        super(driver);
    }

    public void selectMacbookAir() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(macbookAirLink));
        driver.findElement(macbookAirLink).click();
    }
}
