package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Page_Objects.PO_Dashboard;

public class Dashboard extends BasePage {

	public Dashboard(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public Dashboard Verify_Login() {
		wait_until_Visibility(PO_Dashboard.Menu_bar);
		return this;
	}

	public Dashboard Select_All_Ele() {

		wait_until_Invisibility(PO_Dashboard.Map_Loader);
		click(PO_Dashboard.Elevator_DD);

		for (WebElement eHeader_Ele_All : List_of_Elements(PO_Dashboard.Elevator_DD_Values)) {

			if (eHeader_Ele_All.getText().equalsIgnoreCase("Select all")) {
				if (eHeader_Ele_All.getAttribute("Class").equalsIgnoreCase("multiselect-item multiselect-all")) {
					eHeader_Ele_All.click();
				}
				click(PO_Dashboard.Header);
				break;
			}
			wait_until_Invisibility(PO_Dashboard.Map_Loader);
		}

		System.out.println("Selected all elevators");

		return this;
	}

	public Dashboard Select_Some_Ele(String Elevators) throws Exception {

		wait_until_Invisibility(PO_Dashboard.Map_Loader);
		click(PO_Dashboard.Elevator_DD);

		for (WebElement eElevator : List_of_Elements(PO_Dashboard.Elevator_DD_Values)) {

			if (eElevator.getText().equalsIgnoreCase("Select all")) {
				if (eElevator.getAttribute("Class").equalsIgnoreCase("multiselect-item multiselect-all")) {
					eElevator.click();
					eElevator.click();
					break;
				} else {
					eElevator.click();
					break;
				}
			}
		}

		List<String> All_Elevators = String_Split(Elevators);

		for (String sElevator : All_Elevators) {
			for (WebElement eElevator : List_of_Elements(PO_Dashboard.Elevator_DD_Values)) {

				if (sElevator.equalsIgnoreCase(eElevator.getText())) {
					eElevator.click();
					break;
				}
			}
		}

		click(PO_Dashboard.Header);

		wait_until_Invisibility(PO_Dashboard.Map_Loader);

		return this;
	}

	public Farmers Click_Farmers_Menu() {
		wait_until_Invisibility(PO_Dashboard.Map_Loader);
		for (WebElement eFarmers_Menu : List_of_Elements(PO_Dashboard.Farmers_Menu)) {
			if (eFarmers_Menu.getText().equalsIgnoreCase("Farmers")) {
				eFarmers_Menu.click();
				break;
			}
		}
		return new Farmers(driver);
	}

	public Truckers Click_Truckers_Menu() {
		wait_until_Invisibility(PO_Dashboard.Map_Loader);
		for (WebElement eFarmers_Menu : List_of_Elements(PO_Dashboard.Farmers_Menu)) {
			if (eFarmers_Menu.getText().equalsIgnoreCase("Truckers")) {
				eFarmers_Menu.click();
				break;
			}
		}
		return new Truckers(driver);
	}

}