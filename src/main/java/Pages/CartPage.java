package Pages;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class CartPage {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	// categories in the page.
	By phone = By.xpath("(//a[@id='itemc'])[1]");
	By laptops = By.xpath("(//a[@id='itemc'])[2]");
	By monitors = By.xpath("(//a[@id='itemc'])[3]");

	// selecting products.
	By selectedphone = By.partialLinkText("HTC");
	By selectedlaptop = By.partialLinkText("air");
	By selectedmonitors = By.partialLinkText("ASUS");

	// Adding to cart.
	By addtocart = By.xpath("//a[@class='btn btn-success btn-lg']");

	// Deleting an element from cart.
	By deleting = By.partialLinkText("Delete");

	// navigating to CartPage.
	By cartpage = By.id("cartur");

	private WebElement fluentWait(By locator) {
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)) // Set the maximum wait time
				.pollingEvery(Duration.ofSeconds(5)) // Set the polling interval
				.ignoring(NoSuchElementException.class); // Ignore specific exceptions

		return wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
	}
	// Method to check if an element is visible
    public boolean isElementVisible(By locator) {
        try {
            WebElement element = fluentWait(locator);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }

	// methods for selecting categories and selecting the product.
	public void phone() {
		if (isElementVisible(phone)) {
            fluentWait(phone).click();
        } else {
            System.out.println("Phone category is not visible.");
        }

        if (isElementVisible(selectedphone)) {
            fluentWait(selectedphone).click();
        } else {
            System.out.println("Selected phone is not visible.");
        }

        if (isElementVisible(addtocart)) {
            fluentWait(addtocart).click();
        } else {
            System.out.println("Add to cart button is not visible.");
        }
	}

	public void laptops() {
		if (isElementVisible(laptops)) {
            fluentWait(laptops).click();
        } else {
            System.out.println("Laptops category is not visible.");
        }

        if (isElementVisible(selectedlaptop)) {
            fluentWait(selectedlaptop).click();
        } else {
            System.out.println("Selected laptop is not visible.");
        }

        if (isElementVisible(addtocart)) {
            fluentWait(addtocart).click();
        } else {
            System.out.println("Add to cart button is not visible.");
        }
	}

	public void monitors() {
		if (isElementVisible(monitors)) {
            fluentWait(monitors).click();
        } else {
            System.out.println("Monitors category is not visible.");
        }

        if (isElementVisible(selectedmonitors)) {
            fluentWait(selectedmonitors).click();
        } else {
            System.out.println("Selected monitor is not visible.");
        }

        if (isElementVisible(addtocart)) {
            fluentWait(addtocart).click();
        } else {
            System.out.println("Add to cart button is not visible.");
        }
	}

	// Navigate back to home page.
	public void backto() {
		driver.navigate().back();
		driver.navigate().back();
	}

	// Deleting the product from cart.
	public void deletingFromCart() {
		if (isElementVisible(deleting)) {
            fluentWait(deleting).click();
        } else {
            System.out.println("Delete button is not visible.");
        }
	}

	// Navigating to cart page.
	public void cartpage() {
		if (isElementVisible(cartpage)) {
            fluentWait(cartpage).click();
        } else {
            System.out.println("Cart page link is not visible.");
        }
	}
	
		
	}
