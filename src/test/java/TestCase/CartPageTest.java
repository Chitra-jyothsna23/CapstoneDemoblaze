
package TestCase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import base.ExtentReport;
import Pages.CartPage;

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
		driver.get(url); // Opens the website
		c = new CartPage(driver); // Initializes the cart object

		c.phone();

		// Clicks on "Phones" category, selects a phone, and adds it to cart
		c.cartpage();
		driver.navigate().refresh();
		Thread.sleep(3000); // Give time for page reload
		
		screenshot();
		ExtentReport.createTest("Cart").log(Status.PASS, "Add to cart Successfully");
		ExtentReport.getInstance().flush(); // Saves the test report
	}
}
