package Page_Objects;

import org.openqa.selenium.By;

public class PO_Farmers {

	public static final By Create_Btn = By.id("CreateFarmer");

	public static final By Search_boxes = By.className("ag-floating-filter-input");

	public static final By Ag_Grid_Loader = By.className("ag-overlay");

	public static final By Table_Data_First_Row = By.xpath("//*[@row-index = '0']//child::div[3]");

	public static final By Table_First_Row_Edit_Icon = By.xpath("//*[@title = 'Edit']");

	public static final By Loader_Edit_Popup_Open = By.xpath("//*[@class= 'ajax-loader testmodal']");
	
	public static final By Success_Message = By.xpath("//*[@class = 'bootbox modal fade bootbox-alert in']");

	// Create pop up

	public static final By Create_Popup_FirstName = By.id("Create_first_name");

	public static final By Create_Popup_Lastname = By.id("Create_second_name");

	public static final By Create_Popup_Mobile = By.id("Create_mobile");

	public static final By Create_Popup_Email = By.id("Create_email_address");

	public static final By Create_Popup_Ele = By.xpath("//*[@id= 'Create_Elevator']//following::button[1]");

	public static final By Create_Popup_Select_Ele = By.xpath("//*[@class = 'btn-group open']//child::li");

	public static final By Create_Popup_CreateBtn = By.id("Create_farmer");
	
	public static final By Create_Popup_CloseBtn = By.xpath("//*[@id= 'Create_farmer']//preceding::button[1]");
	
	
	//SMS pop up
	
	public static final By SMS_popup_Skip_Btn = By.xpath("//*[@onclick= 'clearToggleSwitch();']");
	
	
	
	

	// Edit Pop up

	public static final By Edit_Popup_FirstName = By.id("edit_first_name");

	public static final By Edit_Popup_Lastname = By.id("edit_second_name");

	public static final By Edit_Popup_Mobile = By.id("edit_mobile");

	public static final By Edit_Popup_Email = By.id("edit_email_address");

	public static final By Edit_Popup_Ele = By.xpath("//*[@id= 'edit_elevator']//following::button[1]");

	public static final By Edit_Popup_Select_Ele = By.xpath("//*[@class = 'btn-group open']//child::li");

	public static final By Edit_Popup_UpdateBtn = By.id("edit_farmerdetails");

}