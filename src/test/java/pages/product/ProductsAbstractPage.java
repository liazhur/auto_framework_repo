package pages.product;

import org.openqa.selenium.WebDriver;

import pages.MainHeaderAbstractPage;
import pages.Tab;

public class ProductsAbstractPage extends MainHeaderAbstractPage {

	protected Tab tab;
//	public ProductsAbstractPage(WebDriver driver, WebDriverWait wait) {
//		super(driver, wait);
//	}

	public ProductsAbstractPage(WebDriver driver, Tab tab) {
		super(driver);
		this.tab = tab;
	}

}
