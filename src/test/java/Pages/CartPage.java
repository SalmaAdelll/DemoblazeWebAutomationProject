package Pages;

import Steps.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {
    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

      public WebElement cartLink() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("cartur")));
    }

    public String getFirstProductName() {
        // Now returns the top product (most recently added)
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tbodyid']/tr[2]/td[2]"))).getText();
    }

    public String getSecondProductName() {
        // Now returns the older product
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tbodyid']/tr[1]/td[2]"))).getText();
    }
    public void deleteAllItemsFromCart() {
        try {
            while (true) {
                WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tbodyid']/tr[1]/td[4]/a")));
                deleteButton.click();
                // Wait until the item disappears before next delete
                wait.until(ExpectedConditions.invisibilityOf(deleteButton));
            }
        } catch (Exception e) {
            // No more items to delete, exit loop
        }
    }

    public String getTotalAmount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("totalp"))).getText();
    }
    public void waitForProductsInCart(int expectedProductCount) {
        wait.until(driver -> driver.findElements(By.xpath("//*[@id='tbodyid']/tr")).size() >= expectedProductCount);
    }




}
