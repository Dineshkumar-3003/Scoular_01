package pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Page_Objects.PO_Truckers;
import utils.Excel_Read_Write;
import utils.Testdata_Path;

public class Truckers extends BasePage {

	public Truckers(WebDriver driver) {
		super(driver);
	}

	Excel_Read_Write Obj_Excel_Read_Write = new Excel_Read_Write();

	public Truckers Create_Trucker() throws Exception {

		click(PO_Truckers.Create_Btn);

		ArrayList<ArrayList<String>> Create_Farmers_Data = Obj_Excel_Read_Write.Excel_Read(
				Testdata_Path.Working_Dir + Testdata_Path.TestData_Loc, Testdata_Path.TD_Filename, "Create_Trucker");

		int iRowcnt = Create_Farmers_Data.size();

		for (int i = 1; i < iRowcnt; i++) {

			String First_Name = Create_Farmers_Data.get(i).get(0);
			String Last_Name = Create_Farmers_Data.get(i).get(1);
			String Phone = Create_Farmers_Data.get(i).get(2);
			String[] All_Elevators = Create_Farmers_Data.get(i).get(3).split(",");
			String sElevator = null;

			writeText(PO_Truckers.Create_Popup_FirstName, First_Name);
			writeText(PO_Truckers.Create_Popup_Lastname, Last_Name);
			writeText(PO_Truckers.Create_Popup_Phone, Phone);

			click(PO_Truckers.Create_Popup_Ele);

			for (int j = 0; j < All_Elevators.length; j++) {
				sElevator = All_Elevators[j].trim();
				for (WebElement eElevator : List_of_Elements(PO_Truckers.Create_Popup_Select_Ele)) {
					if (sElevator.equalsIgnoreCase(eElevator.getText())) {
						eElevator.click();
						break;
					}
				}
			}
			click(PO_Truckers.Create_Popup_CreateBtn);
			click(PO_Truckers.SMS_popup_Skip_Btn);
			wait_until_Invisibility(PO_Truckers.Success_Message);
			wait_until_Invisibility(PO_Truckers.Ag_Grid_Loader);
		}
		return this;
	}

	public Truckers verify_Created_Trucker() throws Exception {

		ArrayList<ArrayList<String>> Create_Farmers_Data = Obj_Excel_Read_Write.Excel_Read(
				Testdata_Path.Working_Dir + Testdata_Path.TestData_Loc, Testdata_Path.TD_Filename, "Create_Trucker");
		int iRowcnt = Create_Farmers_Data.size();

		for (int i = 1; i < iRowcnt; i++) {
			String Phone = Create_Farmers_Data.get(i).get(2);
			int PH_Searchbox_Pos = 3;
			for (WebElement PH_Searchbox : List_of_Elements(PO_Truckers.Search_boxes)) {
				if (PH_Searchbox_Pos == 1) {
					PH_Searchbox.sendKeys(Phone);
					Thread.sleep(2000);
					break;
				}
				PH_Searchbox_Pos--;
			}
			wait_until_Visibility(PO_Truckers.Table_Data_First_Row);
		}
		return this;
	}

	public Truckers Update_Trucker() throws Exception {

		wait_until_Invisibility(PO_Truckers.Ag_Grid_Loader);

		ArrayList<ArrayList<String>> Create_Farmers_Data = Obj_Excel_Read_Write.Excel_Read(
				Testdata_Path.Working_Dir + Testdata_Path.TestData_Loc, Testdata_Path.TD_Filename, "Edit_Trucker");

		int iRowcnt = Create_Farmers_Data.size();
		for (int i = 1; i < iRowcnt; i++) {
			String Old_Phone = Create_Farmers_Data.get(i).get(0);
			int PH_Searchbox_Pos = 3;
			for (WebElement PH_Searchbox : List_of_Elements(PO_Truckers.Search_boxes)) {
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
			String[] All_Elevators = Create_Farmers_Data.get(i).get(4).split(",");
			String sElevator = null;

			click(PO_Truckers.Table_First_Row_Edit_Icon);
			wait_until_Invisibility(PO_Truckers.Loader_Edit_Popup_Open);

			ClearText(PO_Truckers.Edit_Popup_FirstName);
			writeText(PO_Truckers.Edit_Popup_FirstName, First_Name);

			ClearText(PO_Truckers.Edit_Popup_Lastname);
			writeText(PO_Truckers.Edit_Popup_Lastname, Last_Name);

			ClearText(PO_Truckers.Edit_Popup_Phone);
			writeText(PO_Truckers.Edit_Popup_Phone, Phone);

			click(PO_Truckers.Edit_Popup_Ele);

			for (int j = 0; j < All_Elevators.length; j++) {
				sElevator = All_Elevators[j].trim();
				for (WebElement eElevator : List_of_Elements(PO_Truckers.Edit_Popup_Select_Ele)) {
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
			click(PO_Truckers.Edit_Popup_UpdateBtn);
			wait_until_Invisibility(PO_Truckers.Success_Message);
			wait_until_Invisibility(PO_Truckers.Ag_Grid_Loader);

		}
		return this;
	}

	public Truckers verify_Updated_Trucker() throws Exception {

		ArrayList<ArrayList<String>> Create_Farmers_Data = Obj_Excel_Read_Write.Excel_Read(
				Testdata_Path.Working_Dir + Testdata_Path.TestData_Loc, Testdata_Path.TD_Filename, "Edit_Trucker");
		int iRowcnt = Create_Farmers_Data.size();

		for (int i = 1; i < iRowcnt; i++) {
			String Phone = Create_Farmers_Data.get(i).get(3);
			int PH_Searchbox_Pos = 3;
			for (WebElement PH_Searchbox : List_of_Elements(PO_Truckers.Search_boxes)) {
				if (PH_Searchbox_Pos == 1) {
					PH_Searchbox.sendKeys(Phone);
					Thread.sleep(2000);
					break;
				}
				PH_Searchbox_Pos--;
			}
			wait_until_Visibility(PO_Truckers.Table_Data_First_Row);
		}
		return this;
	}

}