package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

public class SummaryTabPage extends BasePage {

	@FindBy(name = "processAddress")
	private WebElement checkoutBtn;

	public SummaryTabPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public WebElement getProceedCheckoutBtn() {
		return checkoutBtn;
	}
}
