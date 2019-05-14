package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentTabPage extends ProductTable {

	public PaymentTabPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public PaymentTabPage(WebDriver driver) {
		super(driver);
	}

}
