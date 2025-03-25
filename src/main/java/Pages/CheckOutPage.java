package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		this.driver=driver;
	}
	By placeorder=By.xpath("//button[@class='btn btn-success']");
	By namefield=By.id("name");
	By countryfield=By.id("country");
	By cityfield=By.id("city");
	By creditcardfield=By.id("card");
	By monthfiels=By.id("month");
	By yearfiels=By.id("year");
	By purchase=By.xpath("(//button[@class='btn btn-primary'])[3]");
	By ok=By.xpath("//button[@class='confirm btn btn-lg btn-primary']");
	
	public void clickPlaceOrder() {
		driver.findElement(placeorder).click();
	}
	public void enterPurchaseDetails(String name,String country,String city,String creditcard,String month,String year) {
		driver.findElement(namefield).sendKeys(name);
		driver.findElement(countryfield).sendKeys(country);
		driver.findElement(cityfield).sendKeys(city);
		driver.findElement(creditcardfield).sendKeys(creditcard);
		driver.findElement(monthfiels).sendKeys(month);
		driver.findElement(yearfiels).sendKeys(year);
	}
	public void confirmPurchase() {
		driver.findElement(purchase).click();
	}
	public void ok() {
		driver.findElement(ok).click();
	}
}