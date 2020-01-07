package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

public class BasePage {
	public WebDriver driver;
	public WebDriverWait wait;

	// Constructor
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	// Wait Wrapper Method
	public void wait_until_Visibility(By elementBy) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
	}

	public void wait_until_Visibility(WebElement Element) {
		wait.until(ExpectedConditions.visibilityOfAllElements(Element));
	}

	// Invisibility of elements

	public void wait_until_Invisibility(By elementBy) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(elementBy));
	}

	// Click Method
	public void click(By elementBy) {
		System.out.println("Clicking");
		wait_until_Visibility(elementBy);
		driver.findElement(elementBy).click();
	}

	public void click(WebElement element) {
		wait_until_Visibility(element);
		element.click();
	}

	// Clear Text
	public void ClearText(By elementBy) {
		wait_until_Visibility(elementBy);
		driver.findElement(elementBy).clear();
	}

	// Write Text
	public void writeText(By elementBy, String text) {
		wait_until_Visibility(elementBy);
		driver.findElement(elementBy).sendKeys(text);
	}

	public void writeText(WebElement element, String text) {
		wait_until_Visibility(element);
		element.sendKeys(text);
	}

	// Read Text
	public String readText(By elementBy) {
		wait_until_Visibility(elementBy);
		return driver.findElement(elementBy).getText();
	}

	// Assert
	public void assertEquals(By elementBy, String expectedText) {
		wait_until_Visibility(elementBy);
		Assert.assertEquals(readText(elementBy), expectedText);

	}

	// List of Elements

	public List<WebElement> List_of_Elements(By elementBy) {
		wait_until_Visibility(elementBy);
		return driver.findElements(elementBy);

	}

	// is displayed

	public void is_displayed(By elementBy) throws InterruptedException {
		// wait_until_Visibility(elementBy);
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(elementBy).isDisplayed());
	}

	public List<String> String_Split(String Text) throws InterruptedException {
		List<String> Text_List = new ArrayList<String>();
		String[] Split = Text.split(",");
		for (String s : Split) {
			s.trim();
			Text_List.add(s);
		}
		return Text_List;

	}

}