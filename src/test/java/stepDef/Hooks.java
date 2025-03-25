package stepDef;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.SignUpPage;
import base.ExtentReport;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	 public static WebDriver driver;
	 @Before
	    public void setup() {
	        driver = new ChromeDriver();// Launches the Chrome browser
	        driver.manage().window().maximize();// Maximizes the browser window
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// Implicit wait for elements
	        driver.get("https://www.demoblaze.com/");
	        
	    }
	 @After
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	            ExtentReport.getInstance().flush();
	        }
	    }
	}


