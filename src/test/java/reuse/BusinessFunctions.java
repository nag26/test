package reuse;




import org.openqa.selenium.WebDriver;

import commands.ActionDriver;
import config.StartBrowser;
import objectrepository.HomePage;
import objectrepository.LoginPage;
import objectrepository.MiddleName;

public class BusinessFunctions {
	
	WebDriver driver;
	ActionDriver aDriver;
	
	public BusinessFunctions()
	{
		driver = StartBrowser.driver;
		aDriver = new ActionDriver();
	}
	
	public void login() throws Exception
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Login to Application");
		aDriver.navigateToApplication("https://manage.chef.io/login");
		aDriver.type(LoginPage.txtUsername, "nagarajkk","Username");
		aDriver.type(LoginPage.txtPassowrd, "Iamalchemist@499", "Password");
		aDriver.click(LoginPage.btnSignin,"Sing in");
	}
	
	public void logout() throws Exception
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Logout from Application");
		aDriver.click(HomePage.nameClick, "Nagaraj Khandibagur");
		aDriver.click(HomePage.signoutClick, "Sign Out");
	}
	public void midlename() throws Exception
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Save Middle Name");
		aDriver.click(MiddleName.clickAdministraion, "Administration");
		aDriver.click(MiddleName.clickUser, "User");
		Thread.sleep(2000);
		aDriver.click(MiddleName.clickUserName, "Username");
		Thread.sleep(2000);
		aDriver.type(MiddleName.txtMiddleName, "Karabasappa", "Father Name");
		Thread.sleep(2000);
		aDriver.click(MiddleName.btnSave, "Save button");
	}
}
