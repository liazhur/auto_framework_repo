package pages.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Log;

public class ProductQuickViewPage extends ProductsAbstractPage {

//	@FindBy(className = "fancybox-iframe")
//	private WebElement iframeSwitchQuickView;
	String iframeSwitchQuickViewClass = "fancybox-iframe";

	public ProductQuickViewPage(WebDriver driver) {
		super(driver);
		switchToIframe();
	}

	public ProductQuickViewPage(WebDriver driver, WebDriverWait wait) {
		super(driver);
		switchToIframe();
	}

	public ProductQuickViewPage switchToIframe() {
		driver.switchTo().frame(driver.findElement(By.className(iframeSwitchQuickViewClass)));
		Log.info("Switched to Product Quick View");
		return this;
	}
}
