package Steps;

import Pages.SignupPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class SignupSteps {

    SignupPage signupPage = new SignupPage();

    @Given("User navigate to Demoblaze website")
    public void userNavigatesToDemoblazeWebsite() {
        signupPage.openHomePage();
    }

    @When("user click on signup button")
    public void userClicksOnSignupButton() {
        signupPage.signUpLink().click();
    }

    @And("user Enter username address {string}")
    public void userEntersUsernameAddress(String username) {
        signupPage.usernameField().sendKeys(username);
    }

    @And("user Enter Password {string}")
    public void userEntersPassword(String password) {
        signupPage.passwordField().sendKeys(password);
    }

    @And("User clicks the Sign up button")
    public void userClicksTheSignUpButton() {
        signupPage.submitSignUpButton().click();
    }

    @Then("web will show Success signup website {string}")
    public void webWillShowSuccessSignupWebsite(String expectedMessage) {
        String actualMessage = signupPage.getSignUpAlertMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
