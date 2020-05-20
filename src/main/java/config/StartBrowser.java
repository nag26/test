package config;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StartBrowser {
	public static WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
	
	@BeforeTest
	public void report()
	{
		htmlReporter = new ExtentHtmlReporter("Reports/MyReports.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("UserName", "Nagaraj");
		htmlReporter.config().setTheme(Theme.DARK);
		//htmlReporter.config().setTimeStampFormat("dd-mm-yyyy hh:mm:ss");
	}
	@BeforeMethod
	public void method(Method method)
	{
		parentTest = extent.createTest(method.getName());
	}
	
	@BeforeClass
	
	public void startBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
		extent.flush();
	}
	
	

}
