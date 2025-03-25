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
import Pages.CartPage;
import Pages.CheckOutPage;

public class CheckOutPageTest extends BaseClass {
	CartPage cp;
	CheckOutPage cop;
	String url,Name,Country,City,Creditcard,Month,Year;
	
	@BeforeTest
	public void readData() throws IOException {
		FileInputStream fis = new FileInputStream("src\\main\\java\\utils\\data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		url = prop.getProperty("url");
		Name = prop.getProperty("name");
		Country=prop.getProperty("country");
		City=prop.getProperty("city");
		Creditcard=prop.getProperty("creditcard");
		Month=prop.getProperty("month");
		Year=prop.getProperty("year");
		fis.close();
		ExtentReport.getInstance();
	}
	@Test 
	public void Tc1() {
		driver.get(url);
		cp=new CartPage(driver);
		// selecting the category phone and adding one of the products to the cart.
		cp.Phone();
		// An alert appears when we add a product to cart we handle that alert.
		AlertHandling();
		//Navigating to home page.
		cp.HomePage();
		//viewing the cart page.
		cp.cartPage();
	}

	@Test
	public void checkout() throws IOException {
		cop=new CheckOutPage(driver);
		// clicking on place order button
		cop.clickPlaceOrder();
		// entering the user details.
		cop.enterPurchaseDetails(Name,Country,City,Creditcard,Month,Year);
		// clicking on purchase button
		cop.confirmPurchase();
		// clicking on ok button.
		cop.ok();
		//capturing the screen shot.
		screenshot();
	}
}