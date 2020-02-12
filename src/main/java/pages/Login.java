package pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Page_Objects.*;
import utils.Excel_Read_Write;
import utils.Testdata_Path;
import utils.URL;

public class Login extends BasePage {

	Excel_Read_Write Obj_Excel_Read_Write = new Excel_Read_Write();

	public Login(WebDriver driver) {
		super(driver);
	}

	public Login App_Launch() {
		driver.get(URL.App_URL);
		return this;
	}

	public Login App_Launch(String URL) {
		driver.get(URL);
		return this;
	}

	public Dashboard Login_Valid() throws Exception {

		ArrayList<ArrayList<String>> All_Data = Obj_Excel_Read_Write
				.Excel_Read(Testdata_Path.Working_Dir + Testdata_Path.TestData_Loc, Testdata_Path.TD_Filename, "login");

		String sUsername = All_Data.get(1).get(0);
		String sPassword = All_Data.get(1).get(1);
		writeText(PO_Login.usernameBy, sUsername);
		writeText(PO_Login.passwordBy, sPassword);
		click(PO_Login.loginButtonBy);
		return new Dashboard(driver);
	}

	public Dashboard Login_Valid_With_data() throws Exception {

		writeText(PO_Login.usernameBy, "Superadmin");
		writeText(PO_Login.passwordBy, "Scoular1");
		click(PO_Login.loginButtonBy);
		return new Dashboard(driver);
	}

	public Login Login_inValid_Null() throws Exception {

		ArrayList<ArrayList<String>> All_Data = Obj_Excel_Read_Write
				.Excel_Read(Testdata_Path.Working_Dir + Testdata_Path.TestData_Loc, Testdata_Path.TD_Filename, "login");

		String sUsername = All_Data.get(1).get(0);
		// String sPassword = All_Data.get(1).get(1);

		writeText(PO_Login.usernameBy, sUsername);
		// writeText(PO_Login.passwordBy, sPassword);
		click(PO_Login.loginButtonBy);
		return this;
	}

	public Login Verify_Error_Msg() throws Exception {

		Assert.assertEquals("Test", readText(PO_Login.Error_Msg));

		return this;
	}

	public Dashboard Login_Valid_with_Page_Factory() throws Exception {

		ArrayList<ArrayList<String>> All_Data = Obj_Excel_Read_Write
				.Excel_Read(Testdata_Path.Working_Dir + Testdata_Path.TestData_Loc, Testdata_Path.TD_Filename, "login");

		String sUsername = All_Data.get(1).get(0);
		String sPassword = All_Data.get(1).get(1);
		PO_Login PF_PO_Login = PageFactory.initElements(driver, PO_Login.class);
		writeText(PF_PO_Login.eUserName, sUsername);
		writeText(PF_PO_Login.ePassword, sPassword);
		click(PF_PO_Login.eLoginBtn);
		return new Dashboard(driver);
	}

	public Login Login_UserName_Text(String sUsername) throws Exception {

		writeText(PO_Login.usernameBy, sUsername);
		return this;
	}

	public Login Login_Password_Text(String sPassword) throws Exception {

		writeText(PO_Login.passwordBy, sPassword);
		return this;
	}

	public Dashboard Login_Submit_Btn_Valid() throws Exception {
		click(PO_Login.loginButtonBy);
		return new Dashboard(driver);
	}

	public Login Login_Submit_Btn_Invalid() throws Exception {
		click(PO_Login.loginButtonBy);
		return this;
	}

	public Login Verify_Error_Msg(String Exp_Err_Msg) throws Exception {

		Assert.assertEquals(Exp_Err_Msg, readText(PO_Login.Error_Msg));
		return this;
	}

}
