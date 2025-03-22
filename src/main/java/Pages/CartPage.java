package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage {
	WebDriver driver;//// WebDriver instance for interacting with the webpage

	public CartPage(WebDriver driver) {
		this.driver = driver;// Assigns the passed WebDriver instance to the class
	}

	// categories in the page
	By Phones = By.xpath("(//a[@id ='itemc'])[1]");
	By Laptops = By.xpath("(//a[@id ='itemc'])[2]");
	By Monitors = By.xpath("(//a[@id ='itemc'])[3]");

	// selecting the items
	By selectedPhone = By.partialLinkText("HTC");
	By selectedLaptop = By.partialLinkText("air");
	By selectedMonitor = By.partialLinkText("ASUS");

	// Adding to cart
	By addtocart = By.xpath("//a[@class='btn btn-success btn-lg']");
	// navigating to cartpage
	By cartpage = By.id("cartur");
	// methods to interact with the elements

	public void Phone() {
		driver.findElement(Phones).click();
		driver.findElement(selectedPhone).click();
		driver.findElement(addtocart).click();

	}

	public void Laptop() {
		driver.findElement(Laptops).click();
		driver.findElement(selectedLaptop).click();
		driver.findElement(addtocart).click();
	}

	public void Monitor() {
		driver.findElement(Monitors).click();
		driver.findElement(selectedMonitor).click();
		driver.findElement(addtocart).click();
	}

	public void cartPage() {
		driver.findElement(cartpage).click();
	}
}
