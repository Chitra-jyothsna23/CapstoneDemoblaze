package TestCase;

	import java.io.IOException;
	import org.testng.annotations.Test;
	import com.aventstack.extentreports.Status;
	import base.BaseClass;
	import base.ExtentReport;
import utils.ExcelReader;
import Pages.LoginPage;


	public class LoginInvalid extends BaseClass {
		LoginPage lip;
		ExcelReader er;
		@Test
		public void LoginInvalid() throws IOException, InterruptedException {
			String username1=er.getData(1,0);
			String password1=er.getData(1, 1);
			String url1 = er.getData(1,2);
			driver.get(url1);
			lip=new LoginPage(driver);
			//clicking on login.
			lip.loginpage();
			//Entering username and password.
			lip.LoginDetails(username1, password1);
			//Clicking loginbutton.
			lip.LoginButton();
			//Handling the alert if present.
			AlertHandling();
			//taking screen shot.
			screenshot();
			ExtentReport.getInstance();
			ExtentReport.createTest("LoginInvalid").log(Status.PASS, "login failed");
			ExtentReport.getInstance().flush();
			
		}
	}


