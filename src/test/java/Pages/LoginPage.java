package Pages;

import Steps.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void openHomePage() {
        driver.get("https://demoblaze.com/");
        driver.manage().window().maximize();
    }

    public WebElement loginLink() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
    }

    public WebElement usernameField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
    }

    public WebElement passwordField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword")));
    }

    public WebElement loginSubmitButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Log in']")));
    }
}
