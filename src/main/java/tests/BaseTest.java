package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import pages.Login;
import utils.Testdata_Path;

public class BaseTest {

	public WebDriver driver;
	public Login Login;

	public WebDriver getDriver() {
		return driver;
	}

	@BeforeClass
	public void classLevelSetup() {

	}

	@BeforeMethod
	public void methodLevelSetup() {

		System.setProperty("webdriver.chrome.driver",
				Testdata_Path.Working_Dir + Testdata_Path.Drivers_Loc + "chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		Login = new Login(driver);

		System.out.println("@BeforeMethod running");
	}

	@AfterMethod
	public void teardown(ITestResult iTestResult) {
		System.out.println("@AfterMethod is called");

		driver.quit();
	}

}