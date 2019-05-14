package pages.tabs;

import org.openqa.selenium.WebDriver;

import pages.MainHeaderAbstractPage;

public class TabsAbstractPage extends MainHeaderAbstractPage {

	protected Tab tab;
//	public ProductsAbstractPage(WebDriver driver, WebDriverWait wait) {
//		super(driver, wait);
//	}

	public TabsAbstractPage(WebDriver driver, Tab tab) {
		super(driver);
		this.tab = tab;
	}

}
