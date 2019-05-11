package pages.product;

import org.openqa.selenium.WebDriver;

import pages.Tab;

public class TShirtsPage extends ProductsAbstractPage {

	public TShirtsPage(WebDriver driver) {
		super(driver, Tab.WOMEN);
	}
}
