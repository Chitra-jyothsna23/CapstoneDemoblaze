package myRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/main/java/features/SignUp.feature",
	    glue = "stepDef",
	    plugin = {"pretty","html:target/cucumber-reports.html"},
	    tags = "@SignUp",  // Runs both valid and invalid test cases
	    monochrome = true
	)
	


public class SignUpTestNGRunner extends AbstractTestNGCucumberTests{

}
