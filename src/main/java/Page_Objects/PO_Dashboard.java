package Page_Objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_Dashboard {

	public static final By Farmers_Menu_By_Text = By.linkText("Farmers");
	public static final By Truckers_Menu = By.linkText("Truckers");

	public final static By Menu_bar = By.id("navbar");

	public final static By Farmers_Menu = By.xpath("//*[@class = 'navbar-collapse collapse navbar-left']//child::li");

	public final static By Elevator_DD = By.xpath("//*[@class = 'elevator_drop_down']");

	public final static By Elevator_DD_Values = By.xpath("//*[@class = 'elevator_drop_down']//child::li");

	public final static By Map_Loader = By.xpath("//*[@id= 'Loading-Img-Map']//child::p");

	public final static By Header = By.xpath("//*[@class = 'navbar navbar-inverse navbar-fixed-top side_menu']");

}
