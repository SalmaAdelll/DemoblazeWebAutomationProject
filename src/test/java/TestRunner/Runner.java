package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "C:\\New folder\\DemoblazeWebAutomationProject\\src\\test\\resources",
        glue = {"Steps"},
        plugin =
                {
                "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                },
        tags = "@smoke"
)
public class Runner extends AbstractTestNGCucumberTests {
}
