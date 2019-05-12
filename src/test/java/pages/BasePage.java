package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public static final long PAGE_LOADING_TIMEOUT = 25;
	public static final long ELEMENT_APPEAR_TIMEOUT = 5;
	public static final long ELEMENT_APPEAR_TIMEOUT_LONG = 10;

	public WebDriver driver;
	public WebDriverWait wait;

	// Constructor
	public BasePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		init();
	}

	public BasePage(WebDriver driver) {
		this.driver = driver;
		init();
	}

	protected void init() {
		PageFactory.initElements(driver, this);
	}

//	 Click Method
	public void click(By elementLocation) {
		driver.findElement(elementLocation).click();
	}
//
//	// Write Text
//	public void writeText(By elementLocation, String text) {
//		driver.findElement(elementLocation).sendKeys(text);
//	}
//
//	// Read Text
//	public String readText(By elementLocation) {
//		return driver.findElement(elementLocation).getText();
//	}
}
