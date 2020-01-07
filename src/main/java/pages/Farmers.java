package pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Page_Objects.PO_Farmers;
import utils.Excel_Read_Write;
import utils.Testdata_Path;

public class Farmers extends BasePage {

	Excel_Read_Write Obj_Excel_Read_Write = new Excel_Read_Write();

	public Farmers(WebDriver driver) {
		super(driver);
	}

	public Farmers Popup_Open_Close() throws Exception {

		System.out.println("Start");

		click(PO_Farmers.Create_Btn);
		System.out.println("First create click");
		click(PO_Farmers.Create_Popup_CloseBtn);
		System.out.println("First close click");
		click(PO_Farmers.Create_Btn);
		System.out.println("second create click");

		click(PO_Farmers.Create_Popup_CloseBtn);
		click(PO_Farmers.Create_Btn);

		click(PO_Farmers.Create_Popup_CloseBtn);
		click(PO_Farmers.Create_Btn);

		click(PO_Farmers.Create_Popup_CloseBtn);
		click(PO_Farmers.Create_Btn);

		return this;

	}

	public Farmers Create_Farmer() throws Exception {

		click(PO_Farmers.Create_Btn);

		ArrayList<ArrayList<String>> Create_Farmers_Data = Obj_Excel_Read_Write.Excel_Read(
				Testdata_Path.Working_Dir + Testdata_Path.TestData_Loc, Testdata_Path.TD_Filename, "Create_Farmer");

		int iRowcnt = Create_Farmers_Data.size();

		for (int i = 1; i < iRowcnt; i++) {

			String First_Name = Create_Farmers_Data.get(i).get(0);
			String Last_Name = Create_Farmers_Data.get(i).get(1);
			String Phone = Create_Farmers_Data.get(i).get(2);
			String Email_Address = Create_Farmers_Data.get(i).get(3);
			String[] All_Elevators = Create_Farmers_Data.get(i).get(4).split(",");
			String sElevator = null;

			writeText(PO_Farmers.Create_Popup_FirstName, First_Name);
			writeText(PO_Farmers.Create_Popup_Lastname, Last_Name);
			writeText(PO_Farmers.Create_Popup_Mobile, Phone);
			writeText(PO_Farmers.Create_Popup_Email, Email_Address);

			click(PO_Farmers.Create_Popup_Ele);

			for (int j = 0; j < All_Elevators.length; j++) {
				sElevator = All_Elevators[j].trim();
				for (WebElement eElevator : List_of_Elements(PO_Farmers.Create_Popup_Select_Ele)) {
					if (sElevator.equalsIgnoreCase(eElevator.getText())) {
						eElevator.click();
						break;
					}
				}
			}
			click(PO_Farmers.Create_Popup_CreateBtn);
			click(PO_Farmers.SMS_popup_Skip_Btn);
			wait_until_Invisibility(PO_Farmers.Success_Message);
			wait_until_Invisibility(PO_Farmers.Ag_Grid_Loader);
		}
		return this;
	}

	public Farmers verify_Created_Farmer() throws Exception {

		ArrayList<ArrayList<String>> Create_Farmers_Data = Obj_Excel_Read_Write.Excel_Read(
				Testdata_Path.Working_Dir + Testdata_Path.TestData_Loc, Testdata_Path.TD_Filename, "Create_Farmer");
		int iRowcnt = Create_Farmers_Data.size();

		for (int i = 1; i < iRowcnt; i++) {
			String Phone = Create_Farmers_Data.get(i).get(2);
			int PH_Searchbox_Pos = 3;
			for (WebElement PH_Searchbox : List_of_Elements(PO_Farmers.Search_boxes)) {
				if (PH_Searchbox_Pos == 1) {
					PH_Searchbox.clear();
					PH_Searchbox.sendKeys(Phone);
					Thread.sleep(2000);
					break;
				}
				PH_Searchbox_Pos--;
			}
			wait_until_Visibility(PO_Farmers.Table_Data_First_Row);
		}
		return this;
	}

	public Farmers Update_Farmer() throws Exception {

		wait_until_Invisibility(PO_Farmers.Ag_Grid_Loader);

		ArrayList<ArrayList<String>> Create_Farmers_Data = Obj_Excel_Read_Write.Excel_Read(
				Testdata_Path.Working_Dir + Testdata_Path.TestData_Loc, Testdata_Path.TD_Filename, "Edit_Farmer");

		int iRowcnt = Create_Farmers_Data.size();
		for (int i = 1; i < iRowcnt; i++) {
			String Old_Phone = Create_Farmers_Data.get(i).get(0);
			int PH_Searchbox_Pos = 3;
			for (WebElement PH_Searchbox : List_of_Elements(PO_Farmers.Search_boxes)) {
				if (PH_Searchbox_Pos == 1) {
					PH_Searchbox.clear();
					PH_Searchbox.sendKeys(Old_Phone);
					Thread.sleep(2000);
					break;
				}
				PH_Searchbox_Pos--;
			}

			String First_Name = Create_Farmers_Data.get(i).get(1);
			String Last_Name = Create_Farmers_Data.get(i).get(2);
			String Phone = Create_Farmers_Data.get(i).get(3);
			String Email_Address = Create_Farmers_Data.get(i).get(4);
			String[] All_Elevators = Create_Farmers_Data.get(i).get(5).split(",");
			String sElevator = null;

			click(PO_Farmers.Table_First_Row_Edit_Icon);
			wait_until_Invisibility(PO_Farmers.Loader_Edit_Popup_Open);

			ClearText(PO_Farmers.Edit_Popup_FirstName);
			writeText(PO_Farmers.Edit_Popup_FirstName, First_Name);

			ClearText(PO_Farmers.Edit_Popup_Lastname);
			writeText(PO_Farmers.Edit_Popup_Lastname, Last_Name);

			ClearText(PO_Farmers.Edit_Popup_Mobile);
			writeText(PO_Farmers.Edit_Popup_Mobile, Phone);

			ClearText(PO_Farmers.Edit_Popup_Email);
			writeText(PO_Farmers.Edit_Popup_Email, Email_Address);

			click(PO_Farmers.Edit_Popup_Ele);

			for (int j = 0; j < All_Elevators.length; j++) {
				sElevator = All_Elevators[j].trim();
				for (WebElement eElevator : List_of_Elements(PO_Farmers.Edit_Popup_Select_Ele)) {
					if (sElevator.equalsIgnoreCase(eElevator.getText())) {
						if (eElevator.getAttribute("class").equalsIgnoreCase("active disableactive_elev")) {
							break;
						} else {
							eElevator.click();
							break;
						}
					}
				}
			}
			click(PO_Farmers.Edit_Popup_UpdateBtn);
			wait_until_Invisibility(PO_Farmers.Success_Message);
			wait_until_Invisibility(PO_Farmers.Ag_Grid_Loader);

		}
		return this;
	}

	public Farmers verify_Updated_Farmer() throws Exception {

		ArrayList<ArrayList<String>> Create_Farmers_Data = Obj_Excel_Read_Write.Excel_Read(
				Testdata_Path.Working_Dir + Testdata_Path.TestData_Loc, Testdata_Path.TD_Filename, "Edit_Farmer");
		int iRowcnt = Create_Farmers_Data.size();

		for (int i = 1; i < iRowcnt; i++) {
			String Phone = Create_Farmers_Data.get(i).get(3);
			int PH_Searchbox_Pos = 3;
			for (WebElement PH_Searchbox : List_of_Elements(PO_Farmers.Search_boxes)) {
				if (PH_Searchbox_Pos == 1) {
					PH_Searchbox.clear();
					PH_Searchbox.sendKeys(Phone);
					Thread.sleep(2000);
					break;
				}
				PH_Searchbox_Pos--;
			}
			wait_until_Visibility(PO_Farmers.Table_Data_First_Row);
		}
		return this;
	}

}