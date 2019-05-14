package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	@FindBy(css = "table[id='cart_summary']")
	private WebElement table;

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

	public List<String> getValuesFromTable() {
		List<WebElement> tableRows = table.findElements(By.tagName("tr"));
		List<WebElement> Cols = new ArrayList<WebElement>();
		List<String> values = new ArrayList<String>();
		for (int i = 0; i < tableRows.size(); i++) {
			WebElement row = tableRows.get(i);
		}
		for (int i = 0; i < tableRows.size(); i++) {
			Cols = tableRows.get(i).findElements(By.tagName("td"));
		}

		for (int j = 0; j < Cols.size(); j++) {
			String el = Cols.get(j).getText();
			values.add(el);
		}
		return values;
	}
}
