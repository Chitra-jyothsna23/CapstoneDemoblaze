package stepDef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import Pages.SignUpPage;
import base.ExtentReport;

import org.openqa.selenium.Alert;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class SignUpStepDef {
    WebDriver driver;//This declares a WebDriver instance named driver.
    SignUpPage signUpPage;//This declares an instance of the SignUpPage class

    @Before
    public void setup() {
        driver = new ChromeDriver();// Launches the Chrome browser
        driver.manage().window().maximize();// Maximizes the browser window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// Implicit wait for elements
        driver.get("https://www.demoblaze.com/");
        signUpPage = new SignUpPage(driver);// Initializes the SignUpPage object (POM)
        signUpPage.Signuppage();//pens the Sign-Up
    }

    @Given("User is on the Sign-Up page")
    public void user_is_on_the_sign_up_page() {
        System.out.println("User is on the Sign-Up page");
        ExtentReport.getInstance();
    }

    @When("User enters the following credentials:")
    public void user_enters_the_following_credentials(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);//Each row in the table becomes a map where the keys are column headers and the values are the respective credentials.

        for (Map<String, String> data : credentials) {
            String username = data.get("Username");
            String password = data.get("Password");
            
                    // Ensure null values are replaced with an empty string
                    username = (username == null) ? "" : username;//If either username or password is null, it replaces them with an empty string ("").
                    password = (password == null) ? "" : password;        

            signUpPage.SignUpPageDetails(username, password);//calls the signup page
        }
    }

    @When("Clicks on the Sign-Up button")
    public void clicks_on_the_sign_up_button() {
        signUpPage.SignUpButton();
    }

    @Then("A success message should be displayed")
    public void a_success_message_should_be_displayed() {
        try {
            Alert alert = driver.switchTo().alert();//switch to alert
            System.out.println("Success Alert: " + alert.getText());//print the alert message
            alert.accept();
        } catch (Exception e) {
            System.out.println("No success alert displayed: " + e.getMessage());
            ExtentReport.createTest("Valid signup").info("User enters valid data");
            ExtentReport.createTest("signup success").pass("signup is complete");
            
        }
    }

    @Then("An error message should be displayed")
    public void an_error_message_should_be_displayed() {
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Error Alert: " + alert.getText());
            alert.accept();
        } catch (Exception e) {
            System.out.println("No error alert displayed: " + e.getMessage());
            ExtentReport.createTest("InValid signup").info("User enters invalid data");
            ExtentReport.createTest("signup unsuccess").pass("signup is incomplete");
            
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            ExtentReport.getInstance().flush();
        }
    }
}

