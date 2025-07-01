package Pages;

import Steps.Hooks;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    private void retryingClick(By locator, int maxAttempts) {
        int attempts = 0;
        while (attempts < maxAttempts) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
                return;
            } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
                System.out.println("Retrying click on: " + locator.toString());
            }
            attempts++;
        }
        throw new RuntimeException("Failed to click after retrying: " + locator.toString());
    }

    public void clickLaptopsCategory() {
        retryingClick(By.xpath("//a[text()='Laptops']"), 3);
    }

    public void clickFirstProduct() {
        retryingClick(By.xpath("//a[text()='Sony vaio i5']"), 3);
    }

    public void clickSecondProduct() {
        retryingClick(By.xpath("//a[text()='Nexus 6']"), 3);
    }

    public void clickAddToCart() {
        retryingClick(By.xpath("//a[text()='Add to cart']"), 3);
    }

    public void clickHomeButton() {
        retryingClick(By.xpath("//a[text()='Home ']"), 3);
    }

    public void waitForHomePageToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbodyid")));
    }

    public void handleAddToCartAlert() {
        try {
            WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            alertWait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert Text: " + alert.getText());
            alert.accept();
            System.out.println("Alert handled successfully.");
        } catch (NoAlertPresentException | TimeoutException e) {
            System.out.println("No alert found after adding to cart.");
        }
    }
}
