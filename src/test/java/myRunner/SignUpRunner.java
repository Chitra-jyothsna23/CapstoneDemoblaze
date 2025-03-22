package myRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/main/java/features/SignUp.feature",
    glue = "stepDef",
    plugin = {"pretty","html:target/cucumber-reports.html"},
    tags = "@SignUp",  // Runs both valid and invalid test cases
    monochrome = true
)
public class SignUpRunner {
}
