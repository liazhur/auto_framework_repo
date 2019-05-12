package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

public class ShippingTabPage extends BasePage {

	@FindBy(css = "input[id='cgv']")
	private WebElement termsOfServiceCheckBox;

	@FindBy(css = "button[name='processCarrier']")
	private WebElement proceedToCheckoutBtn;

	public ShippingTabPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public WebElement getTermsOfServiceCheckBox() {
		return termsOfServiceCheckBox;
	}

	public WebElement getProceedCheckoutBtn() {
		return proceedToCheckoutBtn;
	}

}
