package Page_Objects;

import org.openqa.selenium.By;

public class PO_Truckers {
	
	
	public static final By Create_Btn = By.xpath("//*[@class= 'col-sm-offset-4 col-md-4 panel_head_sort text-right']//child::a");

	public static final By Search_boxes = By.className("ag-floating-filter-input");

	public static final By Ag_Grid_Loader = By.className("ag-overlay");

	public static final By Table_Data_First_Row = By.xpath("//*[@row-index = '0']//child::div[3]");

	public static final By Table_First_Row_Edit_Icon = By.xpath("//*[@title = 'Edit']");

	public static final By Loader_Edit_Popup_Open = By.xpath("//*[@class= 'ajax-loader testmodal']");
	
	public static final By Success_Message = By.xpath("//*[@class = 'bootbox modal fade bootbox-alert in']");

	// Create pop up

	public static final By Create_Popup_FirstName = By.id("First_name");

	public static final By Create_Popup_Lastname = By.id("Last_name");

	public static final By Create_Popup_Phone = By.id("mobile_number");

	public static final By Create_Popup_Ele = By.xpath("//*[@id= 'Create_Elevator']//following::button[1]");

	public static final By Create_Popup_Select_Ele = By.xpath("//*[@class = 'btn-group open']//child::li");

	public static final By Create_Popup_CreateBtn = By.id("CreateTrucker");
	
	
	//SMS pop up
	
	public static final By SMS_popup_Skip_Btn = By.xpath("//*[@onclick= 'clearToggleSwitch();']");
	
	
	
	

	// Edit Pop up

	public static final By Edit_Popup_FirstName = By.id("Edit_First_name");

	public static final By Edit_Popup_Lastname = By.id("Edit_Last_name");

	public static final By Edit_Popup_Phone = By.id("Edit_mobile_number");

	public static final By Edit_Popup_Ele = By.xpath("//*[@id= 'Edit_elevator']//following::button[1]");

	public static final By Edit_Popup_Select_Ele = By.xpath("//*[@class = 'btn-group open']//child::li");

	public static final By Edit_Popup_UpdateBtn = By.id("edit_Trucker");



}