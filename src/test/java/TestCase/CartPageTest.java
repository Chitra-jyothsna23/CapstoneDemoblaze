package TestCase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import base.ExtentReport;
import Pages.CartPage;
import Pages.LoginPage;

public class CartPageTest extends BaseClass {
	CartPage c;
	String url;

	@BeforeTest
	public void readData() throws IOException {
		FileInputStream fis = new FileInputStream("src\\main\\java\\utils\\data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		url = prop.getProperty("url");
		fis.close();
		ExtentReport.getInstance();
	}

	@Test
	public void Cart() throws InterruptedException, WebDriverException, IOException {
		driver.get(url);// opens the website
		c = new CartPage(driver);// initializes the cart object
		c.Phone();
		AlertHandling();// handle alert after adding to the cart
		c.cartPage();// Clicks on "Phones" category, selects a phone, and adds it to cart
		Thread.sleep(3000);
		screenshot();
		ExtentReport.createTest("Cart").log(Status.PASS, "Add to cart Successfully");
		ExtentReport.getInstance().flush();// saves the test report

	}

}
