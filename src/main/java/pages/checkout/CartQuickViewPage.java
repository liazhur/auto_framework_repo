package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

public class CartQuickViewPage extends BasePage {

	@FindBy(css = "div[id=layer_cart] span[title='Continue shopping']")
	private WebElement contShopBtn;

	public CartQuickViewPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public WebElement getContinueShoppingBtn() {
		return contShopBtn;
	}

}
