package TestCase;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import base.ExtentReport;
import Pages.SignUpPage;

public class SignUpTest extends BaseClass {
	
	SignUpPage sip;
	String username, password,url;

	@BeforeTest
	public void readData() throws IOException {
		FileInputStream fis = new FileInputStream("src\\main\\java\\utils\\data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		username = prop.getProperty("username");
		password = prop.getProperty("password");
		url=prop.getProperty("url");
		fis.close();
		ExtentReport.getInstance();
	}

	@Test
	public void SignUpPageMethod() throws WebDriverException, IOException {
		driver.get(url);////opens the website
		sip = new SignUpPage(driver);//initializes the  object
		sip.Signuppage();
		sip.SignUpPageDetails(username, password);
		sip.SignUpButton();
		AlertHandling();
		screenshot();
		ExtentReport.createTest("SignUp").log(Status.PASS,"SignUp Successful");
		ExtentReport.getInstance().flush();
	}
}


