package pages.checkout;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

public class PaymentTabPage extends BasePage {

	@FindBy(css = "table[id='cart_summary']")
	private WebElement paymentTable;

	public PaymentTabPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public PaymentTabPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getPaymentTable() {
		return paymentTable;
	}

	public void getElementFromTable() {
		List<WebElement> tableRows = paymentTable.findElements(By.tagName("tr"));
		List<WebElement> Cols = new ArrayList<WebElement>();
		for (int i = 0; i < tableRows.size(); i++) {
			WebElement row = tableRows.get(i);
		}
		for (int i = 0; i < tableRows.size(); i++) {
			Cols = tableRows.get(i).findElements(By.tagName("td"));
		}

		for (int j = 0; j < Cols.size(); j++) {
			String el = Cols.get(j).getText();
//			if (Cols.get(j).getText().equalsIgnoreCase(ExpectedValue)) {
//			}
		}
	}
}
