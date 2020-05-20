package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import commands.ActionDriver;
import config.StartBrowser;
import reuse.BusinessFunctions;

public class TC01  extends StartBrowser{
	
	WebDriver driver;
	ActionDriver aDriver;
  
	@Test
	public void Login_Logout() throws Exception {
		
		BusinessFunctions bf = new BusinessFunctions();
		bf.login();
		bf.logout();
	}
}
