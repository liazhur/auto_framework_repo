package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryTabPage extends ProductTable {

	@FindBy(css = "a.standard-checkout")
	private WebElement checkoutBtn;

	public SummaryTabPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public SummaryTabPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getProceedCheckoutBtn() {
		return checkoutBtn;
	}
}
