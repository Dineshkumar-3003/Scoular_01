package tests;

import org.testng.annotations.Test;

import ExtentReports.ExtentTestManager;

public class TC_001_Login_Valid extends BaseTest {

	String Class_Name = this.getClass().getCanonicalName();

	@Test(priority = 0, description = "Invalid Login Scenario")
	public void Invalid_Login_Test() throws Exception {

		String Test_Name = new Throwable().getStackTrace()[0].getMethodName();

		ExtentTestManager.startTest(Class_Name, Test_Name, "Invalid Login Scenario.");

		Login.App_Launch().Login_inValid_Null().Verify_Error_Msg();

	}

	@Test(priority = 1, description = "Valid Login Scenario")
	public void Valid_Login_Test() throws Exception {

		String Test_Name = new Throwable().getStackTrace()[0].getMethodName();

		ExtentTestManager.startTest(Class_Name, Test_Name, "Valid Login Scenario.");

		Login.App_Launch().Login_Valid().Verify_Login();

	}

}