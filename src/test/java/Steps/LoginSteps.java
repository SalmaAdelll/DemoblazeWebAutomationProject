package Steps;

import Pages.CartPage;
import Pages.LoginPage;
import Pages.ProductPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();

    @Given("User navigate to Demoblaze website to login")
    public void userNavigatesToDemoblazeWebsiteToLogin() {
        loginPage.openHomePage();
        cartPage.cartLink();
        cartPage.deleteAllItemsFromCart();
        loginPage.openHomePage();
    }

    @When("user click on Login button")
    public void userClicksOnLoginButton() {
        loginPage.loginLink().click();
    }

    @And("user enter username {string}")
    public void userEntersUsername(String username) {
        loginPage.usernameField().sendKeys(username);
    }

    @And("user enter Password {string}")
    public void userEntersPassword(String password) {
        loginPage.passwordField().sendKeys(password);
    }

    @And("User click Login button")
    public void userClicksLoginButton() {
        loginPage.loginSubmitButton().click();
    }

    @And("user choose and open products page")
    public void userChoosesAndOpensProductsPage() {
        productPage.clickLaptopsCategory();
    }

    @And("user can choose first product")
    public void userChoosesFirstProduct() {
        productPage.clickFirstProduct();
    }

    @And("user can add first product to the cart")
    public void userAddsFirstProductToCart() {
        productPage.clickAddToCart();
        productPage.handleAddToCartAlert(); // <-- ALERT HANDLING
    }

    @And("user can go back")
    public void userGoesBack() {
        Hooks.driver.navigate().back();
    }

    @And("user can Click Home")
    public void userClicksHome() {
        productPage.clickHomeButton();
        productPage.waitForHomePageToLoad();
    }


    @And("user can choose second product")
    public void userChoosesSecondProduct() {
        productPage.clickSecondProduct();
    }

    @And("user can add second product to the cart")
    public void userAddsSecondProductToCart() {
        productPage.clickAddToCart();
        productPage.handleAddToCartAlert(); // <-- ALERT HANDLING
    }

    @And("user can open cart page")
    public void userOpensCartPage() {
        cartPage.cartLink().click();
        cartPage.waitForProductsInCart(2); // wait for both items to be added
    }


    @Then("user can check first product name {string}")
    public void userChecksFirstProductName(String expectedName) {
        Assert.assertEquals(cartPage.getSecondProductName(), expectedName); // older = first added
    }

    @Then("user can check Second product name {string}")
    public void userChecksSecondProductName(String expectedName) {
        Assert.assertEquals(cartPage.getFirstProductName(), expectedName); // newer = last added
    }


    @Then("user can check Total {string}")
    public void userChecksTotalAmount(String expectedTotal) {
        String actualTotal = cartPage.getTotalAmount();
        Assert.assertEquals(actualTotal, expectedTotal);
    }
}
