package pages.products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Log;

public class ProductQuickViewPage extends ProductsAbstractPage {

	@FindBy(className = "fancybox-iframe")
	private WebElement iframeSwitchQuickView;

	public ProductQuickViewPage(WebDriver driver) {
		super(driver);
		switchToIframe();
	}

	public ProductQuickViewPage(WebDriver driver, WebDriverWait wait) {
		super(driver);
		switchToIframe();
	}

	public ProductQuickViewPage switchToIframe() {
		driver.switchTo().frame(iframeSwitchQuickView);
		Log.info("Switched to Product Quick View");
		return this;

	}
}
