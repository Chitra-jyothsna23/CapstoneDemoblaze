package Pages;

import org.openqa.selenium.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// elements in login page.
	By loginpage = By.id("login2");
	By userName = By.id("loginusername");
	By Password = By.id("loginpassword");
	By loginbutton = By.xpath("(//button[@class ='btn btn-primary'])[3]");
	By closebutton = By.xpath("(//button[@class='btn btn-secondary'])[1]");

	// methods to invoke these elements.
	public void loginpage() {
		driver.findElement(loginpage).click();
	}

	public void LoginDetails(String username, String password) {
		driver.findElement(userName).sendKeys(username);
		driver.findElement(Password).sendKeys(password);
	}

	public void LoginButton() {
		driver.findElement(loginbutton).click();
	}

	public void CloseButton() {
		driver.findElement(closebutton).click();
	}

	}






