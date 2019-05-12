package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

public class PaymentTab extends BasePage {

	@FindBy(css = "table[id='cart_summary']")
	private WebElement paymentTable;

	public PaymentTab(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public WebElement getPaymentTable() {
		return paymentTable;
	}
}
