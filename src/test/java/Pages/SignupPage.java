package Pages;

import Steps.Hooks;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupPage {
        private WebDriver driver = Hooks.driver;
        private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void openHomePage() {
        driver.get("https://demoblaze.com/");
        driver.manage().window().maximize();
    }

    public WebElement signUpLink() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("signin2")));
    }

    public WebElement usernameField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-username")));
    }

    public WebElement passwordField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-password")));
    }

    public WebElement submitSignUpButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Sign up')]")));
    }

    public String getSignUpAlertMessage() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        alert.accept();
        return message;
    }
}
