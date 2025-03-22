package TestCase;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriverException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import base.ExtentReport;
import Pages.LoginPage;
import Pages.SignUpPage;

public class LoginTest extends BaseClass {

	LoginPage lp;
	String username, password, url;

	@BeforeTest
	public void readData() throws IOException {
		FileInputStream fis = new FileInputStream("src\\main\\java\\utils\\data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		username = prop.getProperty("username");
		password = prop.getProperty("password");
		url = prop.getProperty("url");
		fis.close();
		ExtentReport.getInstance();
	}

	@Test
	public void Login() throws InterruptedException, WebDriverException, IOException {
		driver.get(url);
		lp = new LoginPage(driver);
		lp.loginpage();
		lp.LoginDetails(username, password);
		lp.LoginButton();
		AlertHandling();
		screenshot();
		ExtentReport.createTest("Login").log(Status.PASS, "Login Successful");
		ExtentReport.getInstance().flush();
	}

}
