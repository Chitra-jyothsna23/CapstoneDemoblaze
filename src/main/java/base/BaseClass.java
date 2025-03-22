package base;

import java.io.File;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

public class BaseClass {
	public static WebDriver driver;

	@BeforeClass
	@Parameters("browser") // Receives browser name from testng.xml
	public void setup(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Please enter a valid browser name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://www.demoblaze.com/");
	}

	public void screenshot() throws WebDriverException, IOException {
		File src = null;
		src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("./Screenshots/" + "page" + System.currentTimeMillis() + ".png"));
	}
	public void AlertHandling() {
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));//WebDriverWait is used to wait until a condition to be met
		Alert element = wait.until(ExpectedConditions.alertIsPresent());//waits for an alert to appear within 10 seconds.
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
