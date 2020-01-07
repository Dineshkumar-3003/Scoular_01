package Page_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PO_Login {

	public final static int Reset_Retry = 0;

	public final static By usernameBy = By.id("UserName");
	public final static By passwordBy = By.id("Password");
	public final static By loginButtonBy = By.id("btn-login");

	public final static By Error_Msg = By.xpath("//*[@class = 'col-sm-12 text-center']//child::p");

	// Page Factory

	@FindBy(id = "UserName")
	public WebElement eUserName;

	@FindBy(id = "Password")
	public WebElement ePassword;

	@FindBy(id = "btn-login")
	public WebElement eLoginBtn;
}
