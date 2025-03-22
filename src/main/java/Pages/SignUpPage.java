package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
	WebDriver driver;

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
	}

	// elements in signup page.
	By signuppage = By.id("signin2");
	By userName = By.id("sign-username");
	By Password = By.id("sign-password");
	By signupbutton = By.xpath("(//button[@class='btn btn-primary'])[2]");
	By closebutton = By.xpath("(//button[@class='btn btn-secondary'])[2]");

	// methods to invoke these elements.
	public void Signuppage() {
		driver.findElement(signuppage).click();
	}

	public void SignUpPageDetails(String username, String password) {
		driver.findElement(userName).sendKeys(username);
		driver.findElement(Password).sendKeys(password);
	}

	public void SignUpButton() {
		driver.findElement(signupbutton).click();
	}

	public void CloseButton() {
		driver.findElement(closebutton).click();
	}

	
		
	}

