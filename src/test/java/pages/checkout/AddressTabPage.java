package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

public class AddressTabPage extends BasePage {

	@FindBy(css = "div[id=layer_cart] span[title='Continue shopping']")
	private WebElement proceedToCheckoutBtn;

	public AddressTabPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public WebElement getProceedCheckoutBtn() {
		return proceedToCheckoutBtn;
	}

}
