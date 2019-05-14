package pages.checkout;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

public class ProductTable extends BasePage {

	@FindBy(id = "cart_summary")
	private WebElement paymentTable;

	@FindBy(id = "total_price")
	private WebElement totalValue;

	@FindBy(id = "total_shipping")
	private WebElement totalShipping;

	@FindBy(id = "total_product")
	private WebElement totalProducts;

	public ProductTable(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public ProductTable(WebDriver driver) {
		super(driver);
	}

	public WebElement getPaymentTable() {
		return paymentTable;
	}

	public WebElement getTotalShipping() {
		return totalShipping;
	}

	public WebElement getTotalValue() {
		return totalValue;
	}

	public WebElement getTotalProducts() {
		return totalProducts;
	}

	public List<String> getValuesFromTable() {
		List<WebElement> tableRows = paymentTable.findElements(By.tagName("tr"));
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
